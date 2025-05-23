package ua.nure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class DifferentDigitsNumberTest {

  @Test
  void findNumberConsistingOnlyOfDifferentDigits() {
    DifferentDigitsNumber obj = new DifferentDigitsNumber();
    obj.numbers.addAll(new ArrayList<>(Arrays.asList(2377, 44, 27, 50, 788)));
    Integer res = obj.findDifferentDigitsNumber();
    assertEquals(27, res);
  }

  @Test
  void getNumberOfElementsWithValidInput() {
    String input = "5\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    Scanner sc = new Scanner(in);

    DifferentDigitsNumber obj = new DifferentDigitsNumber();
    int res = obj.getNumberOfElements(sc);
    assertEquals(5, res);
  }

  @Test
  void getNumberOfElementsWithInvalidInputs() {
    String input = "54as\n4\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    Scanner sc = new Scanner(in);
    DifferentDigitsNumber obj = new DifferentDigitsNumber();

    int res = obj.getNumberOfElements(sc);
    assertEquals(4, res);
  }

  @Test
  void assignElementsWithInvalidInputs() {
    String wrongInput = "34uh\n17\nasd\n134\n0df\n199\n6\n344\n";
    List<Integer> expected = new ArrayList<>(Arrays.asList(17, 134, 199, 6, 344));
    InputStream in = new ByteArrayInputStream(wrongInput.getBytes());
    Scanner sc = new Scanner(in);
    DifferentDigitsNumber obj = new DifferentDigitsNumber();

    obj.assignElements(5, sc);
    assertEquals(expected, obj.numbers);
  }

  @ParameterizedTest
  @ValueSource(strings = {"234", "2103", "5", "7593"})
  void consistsOfDifferentDigits(int n) {
    assertTrue(DifferentDigitsNumber.consistsOfDifferentDigits(n));
  }

  @ParameterizedTest
  @ValueSource(strings = {"1232", "5555", "8080", "11"})
  void notConsistOfDifferentDigits(int n) {
    assertFalse(DifferentDigitsNumber.consistsOfDifferentDigits(n));
  }

  @ParameterizedTest
  @ValueSource(strings = {" ", "34hj3", "76.", "qwe", "0", "-48"})
  void isNotValidNumber(String n) {
    assertFalse(DifferentDigitsNumber.isValidNumber(n));
  }

  @ParameterizedTest
  @ValueSource(strings = {"123", "9"})
  void isValidNumber(String n) {
    assertTrue(DifferentDigitsNumber.isValidNumber(n));
  }
}
