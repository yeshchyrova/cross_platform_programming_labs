package ua.nure;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OrganizationManager {
  private final Operator[] operators;
  private final ReentrantLock lock = new ReentrantLock();
  private final Condition condition = lock.newCondition();


  public OrganizationManager(int operatorsCount) {
    operators = new Operator[operatorsCount];
    for (int i = 0; i < operatorsCount; i++) {
      operators[i] = new Operator(i + 1);
    }
  }

  public boolean tryHandleClient(Client client) throws InterruptedException {
    lock.lock();
    Operator operator = getAvailableOperator();
    if (operator == null) {
      lock.unlock();
      return false;
    }
    operator.occupy();
    lock.unlock();
    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
    lock.lock();
    operator.release();
    condition.signalAll();
    lock.unlock();
    return true;
  }

//  public void handleClient(Client client) throws InterruptedException {
//    Operator operator;
//    lock.lock();
//
//    try {
//      while ((operator = getAvailableOperator()) == null) {
//        System.out.printf("Client %s, %d is waiting in line...%n", client.getName(),
//                          client.getId());
//        condition.await();
//      }
//      operator.occupy();
//    } finally {
//      lock.unlock();
//    }
//
//    int spentTimeOnClient = ThreadLocalRandom.current().nextInt(1000, 5000);
//    Thread.sleep(spentTimeOnClient);
//
//    lock.lock();
//    try {
//      operator.release();
//      condition.signalAll();
//    } finally {
//      lock.unlock();
//    }
//    System.out.printf("Client %s, %d has finished talking on the phone...%n", client.getName(),
//                      client.getId());
//
//  }

  private Operator getAvailableOperator() {
    for (Operator operator : operators) {
      if (!operator.isOccupied()) return operator;
    }
    return null;
  }

}
