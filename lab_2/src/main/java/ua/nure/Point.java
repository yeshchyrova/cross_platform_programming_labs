package ua.nure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Point {
  private ComplexNumber x;
  private ComplexNumber y;

  public ComplexNumber getDistanceBetweenTwoPoints(Point second) {
    ComplexNumber firstPart = second.getX().subtract(this.x);
    ComplexNumber secondPart = second.getY().subtract(this.y);
    ComplexNumber doubleFirst = firstPart.multiply(firstPart);
    ComplexNumber doubleSecond = secondPart.multiply(secondPart);
    ComplexNumber sum = doubleFirst.add(doubleSecond);
    return sum.getSqrt();
  }

  public ComplexNumber getDistanceToOrigin() {
    ComplexNumber originXY = new ComplexNumber(0,0);
    ComplexNumber firstPart = originXY.subtract(this.x);
    ComplexNumber secondPart = originXY.subtract(this.y);

    ComplexNumber doubleFirst = firstPart.multiply(firstPart);
    ComplexNumber doubleSecond = secondPart.multiply(secondPart);
    ComplexNumber sum = doubleFirst.add(doubleSecond);
    return sum.getSqrt();
  }


}
