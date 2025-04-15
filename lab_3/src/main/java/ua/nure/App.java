package ua.nure;

//? The organization employs several operators. The operator can serve only one client, the rest
//? must wait in line. The client can hang up and call back again after a while.


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Thread {
  public static int amount = 0;

  @Override
  public void run() {
    amount++;
    System.out.println("this code is running in a thread " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
//    ExecutorService pool = Executors.newFixedThreadPool(4);
//    Runnable task = () -> System.out.println("This code is running in a thread");
//    Thread t = new Thread(task);
//    t.start();
//
//    Thread pureThread = new Thread();
    App thread = new App(); // просто создается объект класса, но сам поток еще не запущен
    thread.start(); // создание потока в операционной системе и после этого запуск run() в этом
    // новом потоке

    while (thread.isAlive()) {
      System.out.println("Waiting...");
    }

    System.out.println("Amount: " + amount);
    amount++;
    System.out.println("Amount: " + amount);
  }
}
