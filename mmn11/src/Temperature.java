package mmn11.src;// Imports

import java.util.Scanner;

/*================
    Code Section
 ================*/

/**
 * mmn 11 - Question 2
 * Calculates the values of inputted temperatures in the 3 formats - F, C, K
 *
 * @Author Yonatan Tzukerman
 * @Date 29/10/2020
 */
public class Temperature {

    public static void main(String[] args) {
        // Scanner and variables
        Scanner scan = new Scanner(System.in);
        char userInputFormat;
        // Need to initialize temperatureInC to avoid compilation error by not having default in the switch
        double temperatureInC = 0, temperatureInF, temperatureInK;
        double userTemperatureInput;

        // Variables used in calculation
        final int FAHRENHEIT_WATER_FREEZE = 32;
        final double FAHRENHEIT_TO_CELSIUS_CONST = 5 / 9.0;
        final double CELSIUS_TO_FAHRENHEIT_CONST = 9 / 5.0;
        final double ABSOLUTE_ABSOLUTE_ZERO_IN_CELSIUS = 273.15;


        // Get input from user
        System.out.println("Please enter the type and temperature value you would like to display: ");
        userInputFormat = scan.next().charAt(0);
        userTemperatureInput = scan.nextDouble();

        // Calculates the value in Celsius
        // While it may be less efficient as 2/3 times there's an added calculation it just makes the code look a bit cleaner
        // By removing the repeated lines that may occur by calculating all 3 values in each case
        switch (userInputFormat) {
            case 'F':
                temperatureInC = (userTemperatureInput - FAHRENHEIT_WATER_FREEZE) * FAHRENHEIT_TO_CELSIUS_CONST;
                break;
            case 'K':
                temperatureInC = userTemperatureInput - ABSOLUTE_ABSOLUTE_ZERO_IN_CELSIUS;
                break;
            case 'C':
                temperatureInC = userTemperatureInput;
                break;
        }

        // Calculate the other values
        // C to k - (C + 273.15)
        temperatureInK = temperatureInC + ABSOLUTE_ABSOLUTE_ZERO_IN_CELSIUS;
        // C to F - (C * 9/5) + 32
        temperatureInF = (temperatureInC * CELSIUS_TO_FAHRENHEIT_CONST) + FAHRENHEIT_WATER_FREEZE;


        // Print out the values
        System.out.println(temperatureInC + " C");
        System.out.println(temperatureInF + " F");
        System.out.println(temperatureInK + " K");

    }
}
