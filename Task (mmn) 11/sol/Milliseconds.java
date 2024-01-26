/**
 * This class converts milliseconds to days, hours, minutes & seconds.
 * 
 * @author: Yuval Pinhas
 * @version: 1.0 - 22/10/21
 */

import java.util.Scanner;

public class Milliseconds {
    public static void main(String[] args) {
        // Defining constants for moving between times
        final int MS_IN_S = 1000; // MS_IN_S = how many milliseconds equals to a second
        final int S_IN_M = 60;    // S_IN_M = how many seconds equals to a minute
        final int M_IN_H = 60;    // M_IN_H = how many minutes equals to a hour
        final int H_IN_D = 24;    // H_IN_D = how many hours equals to a day
        
        // Defining variables for reading the value of the milliseconds and convert the value to seconds, minutes, hours & days
        long ms;    // milliseconds
        long s;     // seconds
        long m = 0; // minutes
        long h = 0; // hours
        long d = 0; // days                  
        
        // Reading input
        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads an integer which " +
            "represents Milliseconds and converts it to days, " +
            "hours, minutes and seconds. ");
        System.out.print("Please enter the number of Milliseconds: ");
        ms = scan.nextLong();
        
        // Calculating
        s = ms / MS_IN_S; 
        if (s >= S_IN_M) {
            m = s / S_IN_M;
            s %= S_IN_M;
            if (m >= M_IN_H) {
                h = m / M_IN_H;
                m %= M_IN_H;
                if (h >= H_IN_D) {
                    d = h / H_IN_D;
                    h %= H_IN_D;
                }
            }
        }

        // Printing output
        System.out.println(d + " days " + h + ":" + m + ":" + s + " hours");
    } // end of method main
} //end of class Milliseconds