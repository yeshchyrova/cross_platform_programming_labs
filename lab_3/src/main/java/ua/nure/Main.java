package ua.nure;

class RunnableDemo implements Runnable {
  private Thread t;
  private String name;

  public RunnableDemo(String name) {
    this.name = name;
    System.out.println("Creating " + name);
  }

  @Override
  public void run() {
    System.out.println("Running " + name);
    try {
      for (int i = 4; i > 0; i--) {
        System.out.println("Thread: " + name + ", " + i);
        Thread.sleep(50);
      }
    } catch (InterruptedException e) {
      System.out.println("Thread " + name + " interrupted.");
    }
    System.out.println("Thread " + name + " exiting.");
  }

  public void start() {
    System.out.println("Starting " + name);
    if (t == null) {
      t = new Thread(this, name);
      t.start();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    RunnableDemo r1 = new RunnableDemo("Thread-one");
    r1.start();
    RunnableDemo r2 = new RunnableDemo("Thread-two");
    r2.start();
  }
}