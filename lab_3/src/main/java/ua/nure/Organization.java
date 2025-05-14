package ua.nure;

//? The organization employs several operators. The operator can serve only one client, the rest
//? must wait in line. The client can hang up and call back again after a while.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Organization {
  private static Logger logger = LoggerFactory.getLogger(Organization.class);


  public static void main(String[] args) {
    final int NUM_AGENTS = 5;
    final int SIMULATION_DURATION = 60;

    CallCenter callCenter = new CallCenter(NUM_AGENTS);

    Random random = new Random();
    long startTime = System.currentTimeMillis();
    while (System.currentTimeMillis() - startTime < SIMULATION_DURATION * 1000) {
      int callDuration = random.nextInt(10) + 1;
      String clientId = "Client" + (random.nextInt(1000) + 1);
      Call call = new Call(callDuration, clientId);
      callCenter.addCall(call);

      int hangupDelay = random.nextInt(15);
      new Thread(() -> {
        try {
          Thread.sleep(hangupDelay * 1000L);
          callCenter.simulateClientHangup(clientId);
        } catch (InterruptedException e) {
          logger.error(e.getMessage());
        }
      }).start();

      try {
        Thread.sleep(random.nextInt(5) * 1000L);
      } catch (InterruptedException e) {
        logger.error(e.getMessage());
      }
    }
    callCenter.shutdown();
  }

}
