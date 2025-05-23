package problems.pat.questions;

import java.util.Scanner;

public class IntersectionOfCircles {
    public static long intersectionArea(double X1, double Y1, double R1, double X2, double Y2, double R2) {
        double distance = Math.sqrt((X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1));

        // Case 1: No intersection
        if (distance >= R1 + R2) return 0L;

        // Case 2: One circle is completely inside another
        if (distance <= Math.abs(R1 - R2)) {
            return (long) (Math.PI * Math.pow(Math.min(R1, R2), 2));
        }

        // Calculate angles for circular segments
        double angle1 = Math.acos((distance * distance + R1 * R1 - R2 * R2) / (2 * distance * R1));
        double angle2 = Math.acos((distance * distance + R2 * R2 - R1 * R1) / (2 * distance * R2));

        // Compute segment areas
        double segment1 = 0.5 * (R1 * R1) * (angle1 - Math.sin(angle1));
        double segment2 = 0.5 * (R2 * R2) * (angle2 - Math.sin(angle2));

        // Return total intersection area
        return (long) (segment1 + segment2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first circle
        System.out.println("Enter x1, y1, r1 for first circle:");
        double X1 = sc.nextDouble();
        double Y1 = sc.nextDouble();
        double R1 = sc.nextDouble();

        // Input second circle
        System.out.println("Enter x2, y2, r2 for second circle:");
        double X2 = sc.nextDouble();
        double Y2 = sc.nextDouble();
        double R2 = sc.nextDouble();

        // Compute and print intersection area
        long intersection = intersectionArea(X1, Y1, R1, X2, Y2, R2);
        System.out.println("Intersection Area: " + intersection);

        sc.close();
    }
}