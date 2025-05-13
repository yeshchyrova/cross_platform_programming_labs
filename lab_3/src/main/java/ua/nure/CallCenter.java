package ua.nure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallCenter {
  private final ExecutorService executorService;
  private final List<CallAgent> agents;
  private final List<BlockingQueue<Call>> callQueues;
  private volatile boolean isRunning = true;
  private static Logger logger = LoggerFactory.getLogger(CallCenter.class);

  public CallCenter(int numberOfAgents) {
    executorService = Executors.newFixedThreadPool(numberOfAgents);
    agents = new ArrayList<>();
    callQueues = new ArrayList<>();

    for (int i = 0; i < numberOfAgents; i++) {
      BlockingQueue<Call> callQueue = new ArrayBlockingQueue<>(10);
      CallAgent agent = new CallAgent(i, callQueue);
      agents.add(agent);
      callQueues.add(callQueue);
      executorService.execute(agent);
    }
  }

  public void addCall(Call call) {
    int minQueueSize = Integer.MAX_VALUE;
    int minQueueIndex = -1;
    for (int i = 0; i < callQueues.size(); i++) {
      int size = callQueues.get(i).size();
      if (size < minQueueSize) {
        minQueueSize = size;
        minQueueIndex = i;
      }
    }
    if (minQueueIndex != -1) {
      callQueues.get(minQueueIndex).offer(call);
      logger.info("Call from client {} added to the agent {}'s queue.", call.getClientId(),
                  (minQueueIndex + 1));
    } else {
      logger.info("All agents are busy. Call from client {} was dropped.", call.getClientId());
    }
  }

  public void simulateClientHangup(String clientId) {
    logger.info("Client {} hung up.", clientId);
  }

  public void shutdown() {
    isRunning = false;
    for (CallAgent agent : agents) {
      agent.release();
    }
    executorService.shutdown();
  }
}
