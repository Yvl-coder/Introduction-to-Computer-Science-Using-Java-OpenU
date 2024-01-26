/**
 * This class plays the Einstein magic game.
 * 
 * @author: Yuval Pinhas
 * @version: 2.0 - 29/10/21
 */

import java.util.Scanner;

public class Einstein {
    public static void main(String[] args) {
        // Defining constant to check if the magic works 
        final int INCREDIBLE_NUM = 1089;

        // Welcome output
        System.out.println("Welcome to the Einstein magic game.");

        // Reading input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different:");
        int num = scan.nextInt();

        // Check the propriety of the input
        if ((num >= 100) && (num <= 999)) {
            if ((num % 10) != (num / 100)) {
                // Printing the value of the number that the user enter
                System.out.println("User number is: " + num);

                // Reverse the number that the user enter
                int reverseNum = (100*(num%10)) + (num%100-num%10) + (num/100);

                // Calculating the difference between the number that the user enter and the reverse of the number
                int difference = Math.abs(num-reverseNum);
                //int difference = Math.max(reverseNum, num) - Math.min(reverseNum, num); <-- another way to calc the positive difference

                // Printing the difference
                System.out.println("Difference: "+difference);

                // Reverse the difference and printing it
                int reverseDifference = (100*(difference%10)) + (difference%100-difference%10) + (difference/100);
                System.out.println("Reversed difference: "+reverseDifference);

                // Checking if the magic works & Printing output
                if ((difference + reverseDifference) == INCREDIBLE_NUM) {
                    System.out.println("SUCCEEDED");
                } else {
                    System.out.println("FAILED");
                }   
            } else {
                // Error output
                System.out.println("The first and the last digits of the number should be different");
            }
        } else {
            // Error output
            System.out.println("The number you entered is not a 3 digit positive number");
        }
    }// end of method main
}// end of class Einstein