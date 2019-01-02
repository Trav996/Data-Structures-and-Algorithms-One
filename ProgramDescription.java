//ProgramDescription.java
//Barrett:Travelle:A00380824:csc122822
//Submission 04
//Temperature Conversion, Part 4

/*
 * The programs works accurately.
 */

import java.util.Scanner;
import java.lang.Object;

/**
 * A class to display the program descripion for the 
 * temperature conversion program.
 */
public class ProgramDescription
{
    // ---------- Class Property ------------------------------------- //
    private Scanner kbd = new Scanner(System.in);
    
    // ---------- Program Method ------------------------------------- //

    /**
     * Displays the program description and pauses at the end for 
     * the user to press Enter to continue.
     */
    public void display()
    {
        System.out.print("\nThis program allows the user to convert either "
                +"a Fahrenheit temperature value\n"
                +"entered by the user to its equivalent Celsius temperature"
                +" value, or vice versa.\n"
                +"In either case, it then displays both the original and"
                +" the converted values.\n"
                +"\n"+ "The program may convert any number of values of "
                +"either type on any given run.\n"
                +"On each pass the user must either choose to quit, or "
                +"choose what kind of value\n"
                + "he or she wishes to convert. If a conversion option is "
                +"chosen, then a valid\n"
                + "numerical value (real number or integer) is the expected"
                +" input, and the program\n"
                + "is not responsible if anything other than a number is"
                +" entered.\n"
                + "\n"
                + "A Fahrenheit temperature value is valid (in our case) if"
                +" it is a real number\n"
                + "lying within the range -459.67..212.00. A Celsius "
                +"temperature value is valid\n"
                + "(in our case) if it is a real number lying within the "
                +" range -273.15..100.00.\n"
                + "These value ranges reflect the fact that we are only "
                +"interested in, and only\n"
                + "deal with, temperatures between absolute zero and the "
                +"boiling point of water.\n"
                + "\n"
                + "If any temperature value does not lie within the "
                +"acceptable range, an error\n"
                + "must be reported and the value must be ignored by "
                +"the program, which simply\n"
                + "asks for another value after reporting the error. In "
                +"addition, if the user\n"
                + "does not respond correctly when asked to choose the kind "
                +"of value to convert,\n"
                + "at that point the program also reports the error and "
                +"repeats the request.\n"
                + "The user has three tries to enter a valid request.\n"
                + "\t\t\t\t\t\t\t\t    Page 1 of 1");

         System.out.print("\nPress Enter to continue ... ");
         kbd.nextLine();
    }

    /**
     *A simple test driver for this class. It creates an object of 
     *this class and then displays it.
     */
    public static void main (java.lang.String[] args)
    {
        ProgramDescription description = new ProgramDescription();
        description.display();

    }


}//end class
