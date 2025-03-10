package ua.nure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class DifferentDigitsNumberTest {
  @BeforeEach
  void resetNumbers() {
    DifferentDigitsNumber.numbers.clear();
  }

  @Test
  void findNumberConsistingOnlyOfDifferentDigits() {
    String input = "2377\n44\n27\n50\n788";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    Scanner sc = new Scanner(in);

    DifferentDigitsNumber.assignElements(5, sc);
    Integer res = DifferentDigitsNumber.findDifferentDigitsNumber();
    assertEquals(27, res);
  }

  @Test
  void readAmountOfElements() {
    String input = "5\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    Scanner sc = new Scanner(in);

    int res = DifferentDigitsNumber.getNumberOfElements(sc);
    assertEquals(5, res);
  }

  @Test
  void readInvalidAmountOfElements() {
    String input = "54as\n4\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    Scanner sc = new Scanner(in);

    int res = DifferentDigitsNumber.getNumberOfElements(sc);
    assertEquals(4, res);
  }

  @Test
  void invalidNumbersInput() {
    String wrongInput = "34uh\n17\nasd\n134\n0df\n199\n6\n344\nqwer";
    InputStream in = new ByteArrayInputStream(wrongInput.getBytes());
    Scanner sc = new Scanner(in);

    DifferentDigitsNumber.assignElements(5, sc);
    Integer res = DifferentDigitsNumber.findDifferentDigitsNumber();
    assertEquals(17, res);
  }

  @Test
  void ifConsistsOfDifferentDigits() {
    assertTrue(DifferentDigitsNumber.consistsOfDifferentDigits(234));
    assertTrue(DifferentDigitsNumber.consistsOfDifferentDigits(2103));
    assertTrue(DifferentDigitsNumber.consistsOfDifferentDigits(5));
    assertTrue(DifferentDigitsNumber.consistsOfDifferentDigits(7593));
    assertFalse(DifferentDigitsNumber.consistsOfDifferentDigits(1232));
    assertFalse(DifferentDigitsNumber.consistsOfDifferentDigits(5555));
    assertFalse(DifferentDigitsNumber.consistsOfDifferentDigits(8080));
    assertFalse(DifferentDigitsNumber.consistsOfDifferentDigits(11));
  }

  @Test
  void ifIsValidNumber() {
    assertFalse(DifferentDigitsNumber.isValidNumber(""));
    assertFalse(DifferentDigitsNumber.isValidNumber("34hj3"));
    assertFalse(DifferentDigitsNumber.isValidNumber("76."));
    assertFalse(DifferentDigitsNumber.isValidNumber("qwe"));
    assertFalse(DifferentDigitsNumber.isValidNumber("0"));
    assertFalse(DifferentDigitsNumber.isValidNumber("-48"));
    assertTrue(DifferentDigitsNumber.isValidNumber("123"));
    assertTrue(DifferentDigitsNumber.isValidNumber("9"));
  }
}
