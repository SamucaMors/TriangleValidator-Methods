import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner(System.in);

        //Triangle X
        String nameX = "X";
        double areaX = processTriangle(nameX, read);

        //triangle Y
        String nameY = "Y";
        double areaY = processTriangle(nameY, read);

        compareAreas(areaX, areaY, nameX, nameY);

        read.close();
    }

        // Method for processing a triangle
    public static double processTriangle(String triangleName, Scanner scanner) {
        double sideA, sideB, sideC;

        while (true) {
            System.out.printf("Enter the sides of triangle %s:%n", triangleName);
            System.out.print("Side A: ");
            sideA = scanner.nextDouble();

            System.out.print("Side B: ");
            sideB = scanner.nextDouble();

            System.out.print("Side C: ");
            sideC = scanner.nextDouble();

            if (isValidTriangle(sideA, sideB, sideC)) {
                System.out.println("The values can form a triangle!");
                double area = calculateArea(sideA, sideB, sideC);
                System.out.printf("Area of triangle %s: %.2f%n", triangleName, area);
                return area;
            } else {
                System.out.println("The values cannot form a triangle. Please try again.");
            }
        }
    }

    // Method to check whether the sides form a triangle
    public static boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA;
    }

    // Method for calculating the area using Heron's formula
    public static double calculateArea(double sideA, double sideB, double sideC) {
        double semiPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    // Method for comparing the areas of two triangles
    public static void compareAreas(double areaX, double areaY, String nameX, String nameY) {
        if (areaX > areaY) {
            System.out.println(String.format("Area of the triangle %s is greater than Area %s.", nameX, nameY ));
        } else if (areaX < areaY) {
            System.out.println(String.format("Area %s is greater than Area %s.", nameY, nameX));
        } else {
            System.out.println("Both areas are equal.");
        }
    }
}
