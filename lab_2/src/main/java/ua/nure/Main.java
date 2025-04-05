package ua.nure;

public class Main {
  public static void main(String[] args) {
    ComplexNumberList object = new ComplexNumberList();
    ComplexNumber[] complexNumbers = object.getComplexNumbers();

    Point firstPoint = new Point(complexNumbers[0], complexNumbers[1]);

    Point secondPoint = new Point(complexNumbers[2], complexNumbers[3]);

    ComplexNumber distanceBetweenPoints = firstPoint.getDistanceBetweenTwoPoints(secondPoint);
    ComplexNumber fromFirstPointToOrigin = firstPoint.getDistanceToOrigin();
    ComplexNumber fromSecondPointToOrigin = secondPoint.getDistanceToOrigin();
    System.out.println(
            "The distance between (3+i;2+2i) and (1+4i;2+i) is: " + distanceBetweenPoints.getFormatted());


    System.out.println("From (3+i;2+2i) to (0;0) is: " + fromFirstPointToOrigin.getFormatted());
    System.out.println("From (1+4i;2+i) to (0;0) is: " + fromSecondPointToOrigin.getFormatted()
                      );
  }

}
