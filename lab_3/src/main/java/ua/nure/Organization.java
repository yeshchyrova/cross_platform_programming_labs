package ua.nure;

//? The organization employs several operators. The operator can serve only one client, the rest
//? must wait in line. The client can hang up and call back again after a while.

import java.util.concurrent.ThreadLocalRandom;

public class Organization {

  public static void main(String[] args) {
    final int NUM_AGENTS = 5;
    final int SIMULATION_DURATION = 60;

    CallCenter callCenter = new CallCenter(NUM_AGENTS);

  }

}
