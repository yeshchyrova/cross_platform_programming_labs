package ua.nure;

import lombok.Getter;
import java.util.*;

//? Enter n numbers from the console. Find the number consisting only of different digits.
//? If there are several such numbers, find the first one

@Getter
public class DifferentDigitsNumber {
  final List<Integer> numbers = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DifferentDigitsNumber obj = new DifferentDigitsNumber();

    int n = obj.getNumberOfElements(sc);

    System.out.println("Enter " + n + " numbers:");
    obj.assignElements(n, sc);
    System.out.println("Numbers: " + obj.numbers);
    Integer res = obj.findDifferentDigitsNumber();

    if (res == null) System.out.println("No number consisting only of different digits.");
    else System.out.println("The first number consisting only of different digits is " + res);
  }

  public static boolean isValidNumber(String input) {
    return !input.isEmpty() && input.matches("[1-9]\\d*");
  }

  public int getNumberOfElements(Scanner sc) {
    int n = 0;
    boolean isValidN = false;

    while (!isValidN) {
      System.out.println("Enter amount of elements: ");
      String input = sc.nextLine();

      if (isValidNumber(input)) {
        n = Integer.parseInt(input);
        isValidN = true;
      } else System.out.println("Wrong input. Please try again.");

    }

    return n;
  }

  public void assignElements(int n, Scanner sc) {
    int k = 0;
    while (k < n) {
      String input = sc.nextLine();
      if (isValidNumber(input)) {
        numbers.add(Integer.parseInt(input));
        k++;
      } else System.out.println("Wrong input. Please try again.");
    }
  }

  public Integer findDifferentDigitsNumber() {
    for (int number : numbers) {
      if (consistsOfDifferentDigits(number)) return number;
    }
    return null;
  }

  public static boolean consistsOfDifferentDigits(int n) {
    String strNum = Integer.toString(n);
    Set<Character> digits = new HashSet<>();

    for (char digit : strNum.toCharArray()) {
      if (!digits.add(digit)) {
        return false;
      }
    }
    return true;
  }
}
