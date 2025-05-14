package ua.nure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Call {
  private final int duration;
  private final String clientId;
}
