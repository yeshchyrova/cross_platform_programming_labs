package ua.nure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ComplexNumber {
  private double real;
  private double imaginary;

  public ComplexNumber add(ComplexNumber second) {
    double newReal = this.real + second.getReal();
    double newImaginary = this.imaginary + second.getImaginary();
    return new ComplexNumber(newReal, newImaginary);
  }

  public ComplexNumber subtract(ComplexNumber second) {
    double newReal = this.real - second.getReal();
    double newImaginary = this.imaginary - second.getImaginary();
    return new ComplexNumber(newReal, newImaginary);
  }


  public ComplexNumber multiply(ComplexNumber second) {
    double newReal = this.real * second.getReal() - this.imaginary * second.getImaginary();
    double newImaginary = this.real * second.getImaginary() + this.imaginary * second.getReal();
    return new ComplexNumber(newReal, newImaginary);
  }

  public ComplexNumber getSqrt() {
    double r = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    double rootReal = Math.sqrt((r + this.real) / 2);
    double rootImaginary = Math.sqrt((r - this.real) / 2);

    if (this.imaginary < 0) {
      rootImaginary = -rootImaginary;
    }

    return new ComplexNumber(rootReal, rootImaginary);
  }

  public String getFormatted() {
    StringBuilder str = new StringBuilder();
    str.append(String.format("%.5f", this.real));
    if(this.imaginary < 0) str.append(" - ").append(String.format("%.5f", -this.imaginary)).append(
            "i");
    if(this.imaginary > 0) str.append(" + ").append(String.format("%.5f", this.imaginary)).append("i");
    return str.toString();
  }
}
