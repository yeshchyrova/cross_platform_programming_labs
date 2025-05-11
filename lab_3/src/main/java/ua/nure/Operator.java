package ua.nure;

import lombok.Getter;

public class Operator {
  @Getter
  private final int id;
  private boolean isOccupied;

  public Operator(int id) {
    this.id = id;
    this.isOccupied = false;
  }

  public boolean occupy() {
    if (!isOccupied) {
      isOccupied = true;
      return true;
    }
    return false;
  }

  public void release() {
    isOccupied = false;
  }

  public boolean isOccupied() {
    return isOccupied;
  }
}
