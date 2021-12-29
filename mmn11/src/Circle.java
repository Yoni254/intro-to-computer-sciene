package mmn11.src;
// Imports
import java.util.Scanner;

/*
====================
    Code Section
====================
 */

/**
 * mmn 11 - question 1
 *
 * This program asks user for 2 coordinates and calculates the radius area and perimeter
 * of the inscribed circle and the circumscribed circle.
 *
 *
 * @Author Yonatan Tzukerman
 * @Date 29/10/2020
 */
public class Circle {

    public static void main(String[] args) {
        // Scanner and variables
        Scanner scan = new Scanner(System.in);
        // User inputs
        int upperLeftX, upperLeftY, lowerRightX, lowerRightY;
        // Will be used when printing
        double radius, area, perimeter;
        // Temporary Variables to aid in calculations
        int rectangleWidth, rectangleLength;

        // On start message
        System.out.println("This program calculates the areas and the " +
                "perimeters of the excircle and the incircle of a given rectangle ");


        // Get input from user
        // Left upper corner
        System.out.print("Please enter the two coordinates of the left-upper point of the rectangle: ");
        upperLeftX = scan.nextInt();
        upperLeftY = scan.nextInt();
        // Lower right corner
        System.out.print("Please enter the two coordinates of the right-lower point of the rectangle: ");
        lowerRightX = scan.nextInt();
        lowerRightY = scan.nextInt();


        // Calculating and printing out the values
        // Radius - diameter / 2
        // Perimeter - 2 * PI * radius
        // area = PI * radius^2

        // Calculate the length and width
        rectangleLength = upperLeftY - lowerRightY;
        rectangleWidth = lowerRightX - upperLeftX;

        // Calculations of inscribed circle
        // Diameter of inscribed is upperLeftY - lowerRightY
        radius = rectangleLength / 2.0;
        perimeter = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        System.out.println("Incircle: " + "radius = " + radius + ", area = " + area + ", perimeter = " + perimeter);

        // Calculations of circumscribed circle
        // Diameter of excircle is the distance from upperLeftX,upperLeftY to lowerRightX,lowerRightY
        radius = Math.sqrt(Math.pow(rectangleLength, 2) + Math.pow(rectangleWidth, 2)) / 2.0;
        perimeter = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        System.out.println("Excircle: " + "radius = " + radius + ", area = " + area + ", perimeter = " + perimeter);


    }

}
