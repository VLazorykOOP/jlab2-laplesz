import java.util.Scanner;

public class st {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sides of the first rectangle:");
        System.out.print("Side A: ");
        double a1 = scanner.nextDouble();
        System.out.print("Side B: ");
        double b1 = scanner.nextDouble();
        Rectangle r1 = new Rectangle(a1, b1);

        System.out.println("\nEnter the sides of the second rectangle:");
        System.out.print("Side A: ");
        double a2 = scanner.nextDouble();
        System.out.print("Side B: ");
        double b2 = scanner.nextDouble();
        Rectangle r2 = new Rectangle(a2, b2);

        System.out.println("\nFirst rectangle:");
        System.out.println("Area r1: " + r1.getArea());
        System.out.println("Perimeter r1: " + r1.getPerimeter());

        System.out.println("\nSecond rectangle:");
        System.out.println("Area r2: " + r2.getArea());
        System.out.println("Perimeter r2: " + r2.getPerimeter());

        System.out.println("\nComparison:");
        System.out.println("r1 і r2 have the same area: " + r1.hasSameArea(r2));
        System.out.println("r1 і r2 are similar: " + r1.isSimilar(r2));

        scanner.close();
    }
}

class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getArea() {
        return sideA * sideB;
    }

    public double getPerimeter() {
        return 2 * (sideA + sideB);
    }

    public boolean hasSameArea(Rectangle other) {
        return Double.compare(this.getArea(), other.getArea()) == 0;
    }

    public boolean isSimilar(Rectangle other) {
        double ratio1 = this.sideA / this.sideB;
        double ratio2 = other.sideA / other.sideB;
        return Double.compare(ratio1, ratio2) == 0 || Double.compare(ratio1, 1 / ratio2) == 0;
    }
}
