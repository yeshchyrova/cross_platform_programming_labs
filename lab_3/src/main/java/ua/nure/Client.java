package ua.nure;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Client implements Runnable {
  private int id;
  private String name;
  private OrganizationManager organizationManager;

  public Client(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public void run() {
    while (true) {
      boolean succeeded;
      try {
        succeeded = tryToTalk();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      if (succeeded) break;
      else {
        System.out.println("Operators are not available, hanging up.");
        try {
          Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public boolean tryToTalk() throws InterruptedException {
    return organizationManager.tryHandleClient(this);
  }

}
