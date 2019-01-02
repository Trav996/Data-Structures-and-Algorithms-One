//Converter.java
//Barrett:Travelle:A00380824:csc122822
//Submission 04
//Temperature Conversion, Part 4

/*
 * The programs works accurately.
 */

import java.util.Scanner;
import java.lang.Object;

/**
 * A class to read in and validate a Fahrenheit or 
 * Celsius temperature and also display both the input 
 * temperature and its corresponding value on the other 
 * temperature scale. 
 */
public class Converter
{
    // ---------- Class Properties ------------------------------------- //
    private Scanner kbd = new Scanner(System.in);
    private double fTemp;
    private double cTemp;
    private boolean running = true;
    private boolean userResponseIsOk;

    // ---------- Program Methods ------------------------------------- //

    /**
     * Reads a Fahrenheit temperature from the user at the 
     * keyboard and checks the value for validity.
     */
    public void readFahrenheitTemperature()
    {
        running = true;
        while (running)
        {
            System.out.print("\nEnter a Fahrenheit temperature " 
                    +"in the range -459.67 to 212.00: ");
            fTemp = kbd.nextDouble();
            kbd.nextLine();

        if (fTemp <= 212.00 && fTemp >= -459.67) //check if value in range
        {
            cTemp = (fTemp - 32) * 5 / 9; //Convert to celsius
            running = false;
            userResponseIsOk = false;
        }
        else 
        {
            System.out.print("\nError: Fahrenheit temperature out of range."
                    +"\nTry again."
                    + "\nPress Enter to continue ...");
            kbd.nextLine();
        }
        }
        
    }

    /**
     * Reads a Celsius temperature from the user at the keyboard and 
     * checks the value for validity.
     */
    public void readCelsiusTemperature()
    {
        running = false;
        while (!running)
        {
            System.out.print("\nEnter a Celsius temperature " 
                    +"in the range -273.15 to 100.00: ");
            cTemp = kbd.nextDouble();
            kbd.nextLine(); 

        if (cTemp >= -273.15 && cTemp <= 100.00)//check if value in range 
        {
            fTemp = (cTemp * 9 / 5) + 32; //Convert to fahrenheit 
            running = true;
            userResponseIsOk = true;  
        } 
        else 
        {
            System.out.print("\nError: Invalid Celsius temperature.\n"
                    + "Try again.\n"
                    + "Press Enter to continue ..."); 
            kbd.nextLine();   
        }   
        }
    }
    
    /**
     * Displays both the Fahrenheit and Celsius values of the 
     * currently stored temperature.
     */
    public void displayBothValues()
    {
        if (!userResponseIsOk)
        {
            userResponseIsOk = true;
            System.out.printf("The corresponding Celsius value "
                    +"of Fahrenheit value %.2f", fTemp); 
            System.out.printf(" is %.2f.\n", cTemp);
            System.out.print("Press Enter to continue ...");
            kbd.nextLine();
            
        }
        else
        {
            userResponseIsOk = false;
            System.out.printf("The corresponding Fahrenheit value "
                    +"of Celsius value %.2f", cTemp);
            System.out.printf(" is %.2f.\n", fTemp);
            System.out.print("Press Enter to continue ...");
            kbd.nextLine();
            
        }
    }

    /**
     * A simple test driver for this class.It first attempts to read
     *  a Fahrenheit temperature and then display both it and its 
     *  corresponding Celsius value. Second, it attempts to read a Celsius 
     *  value and then display both it and its corresponding Fahrenheit value.
     */
    public static void main(java.lang.String[] args)
    {
        // ---------- Method Calls ------------------------------------- //
        do
        {
        Converter c = new Converter();
        c.readFahrenheitTemperature();
        c.displayBothValues();
        c.readCelsiusTemperature();
        c.displayBothValues();
        }
        while (true);

    }//end main

}//end Converter
