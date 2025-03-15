package ua.nure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BasicsTest {
  @Test
  @DisplayName("First number is greater than the second")
  void compare() {
    Basics basics = new Basics();
    int value = basics.compare(2,1);
    assertEquals(1, value);
  }

  @Test
  @DisplayName("First number is lower than the first")
  public void compare2() {
    Basics basics = new Basics();
    int value = basics.compare(1,4);
    assertEquals(-1, value);
  }

  @Test
  @DisplayName("Both numbers are equal")
  void compare3() {
    Basics basics = new Basics();
    int value = basics.compare(1,1);
    assertEquals(0, value);
  }

  @Test
  void compareFull() {
    Basics basics = new Basics();
    int value1 = basics.compare(2,1);
    int value2 = basics.compare(1,3);
    int value3 = basics.compare(2,2);

    assertEquals(1, value1);
    assertEquals(-1, value2);
    assertEquals(0, value3);
  }
}
