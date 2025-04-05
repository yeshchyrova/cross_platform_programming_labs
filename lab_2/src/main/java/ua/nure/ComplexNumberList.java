package ua.nure;

import lombok.Getter;

@Getter
public class ComplexNumberList {
  private final ComplexNumber[] complexNumbers;

  public ComplexNumberList() {
    complexNumbers = new ComplexNumber[]{
            new ComplexNumber(3, 1),
            new ComplexNumber(2, 2),
            new ComplexNumber(1, 4),
            new ComplexNumber(2, 1)
    };
  }
}
