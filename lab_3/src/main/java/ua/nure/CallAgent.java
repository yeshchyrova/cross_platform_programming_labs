package ua.nure;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

@RequiredArgsConstructor
public class CallAgent implements Runnable {
  private final int id;
  private final BlockingQueue<Call> callQueue;
  private volatile boolean isRunning = true;
  private static final Logger logger = LoggerFactory.getLogger(CallAgent.class);


  public void release() {
    isRunning = false;
  }

  @Override
  public void run() {
    while (isRunning) {
      try {
        Call call = callQueue.take();
        System.out.printf("Agent %d is handling call from client %s for %d seconds.%n", id,
                          call.getClientId(), call.getDuration());
        Thread.sleep(call.getDuration() * 1000L);
        System.out.printf("Agent %d finished call from client %s.%n", id, call.getClientId());
      } catch (InterruptedException e) {
        logger.error(e.getMessage());
        throw new RuntimeException(e.getMessage());
      }
    }
  }
}
