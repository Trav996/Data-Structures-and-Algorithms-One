//--This is the shell program, so change the file name and remove this line.
//TemperatureConversion2_shell.java
//--Modify the following line to contain your own information.
//Lastname:Firstname:A00123456:csc122801
//Submission 02
//Temperature Conversion, Part 2

/*
 * Your program self-assessment goes here, as a courtesy to the marker.
 */

import java.util.Scanner;


/**
 * This class contains a complete program for converting between
 * Fahrenheit and Celsius temperatures.
 */
public class TemperatureConversion2
{
    //Variables
    public static Scanner keyboard = new Scanner(System.in);
    final static double FTEMPMIN = -459.67;
    final static double FTEMPMAX = 212.00;
    final static double CTEMPMIN = -273.15;
    final static double CTEMPMAX = 100.00;
    public static boolean fFromUser = false;
    public static boolean cFromUser = false;
    public static double fTemp;
    public static double cTemp;

    public static void main(String[] args)
    {
        //Variables
        char decision;

        //Call methods
        TemperatureConversion2.displayIdentificationInfo();
        keyboard.nextLine();
        TemperatureConversion2.displayProgramDescription();
        while (true)
        {
            TemperatureConversion2.getRequestedAction();
        }
    }


    /**
     * Displays identification information and pauses for user to press Enter.
     */
    private static void displayIdentificationInfo()
    {
        System.out.print("\n" + "\n" + "\n"
                + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
        System.out.print("                McRonald:Daniel:A00395400:csc122850"
                + "\n                Submission 02"
                + "\n                Temperature Conversion, Part 2");
        System.out.print("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
                + "\n" + "\n" + "\n" + "\n" + "Press Enter to continue ...");
    }


    /**
     * Displays program description and pauses for user to press Enter.
     */
    private static void displayProgramDescription()
    {
      System.out.print("\nThis program allows the user to convert either a " 
              + "Fahrenheit temperature value"
              + "\nentered by the user to its equivalent Celsius temperature" 
              + "value, or vice versa."
              + "\nIn either case, it then displays both the original and the "
              + "converted values."); 
              
      System.out.print("\n\nThe program may convert any number of values of "
              + "either type on any given run."
              + "\nOn each pass the user must either choose to quit, or choose"
              + " what kind of value "
              + "\nhe or she wishes to convert. If a conversion option is "
              + "chosen, then a valid"
              + "\nnumerical value (real number or integer) is the expected "
              + "input, and the program"
              + "\nis not responsible if anything other than a number is "
              + "entered.");
             
      System.out.print("\n\nA Fahrenheit temperature value is valid (in our "
              + "case) if it is a real number"
              + "\nlying within the range -459.67..212.00. A Celsius "
              + "temperature value is valid"
              + "\n(in our case) if it is a real number lying within the range"
              + "-273.15..100.00."
              + "\nThese value ranges reflect the fact that we are only "
              + "interested in, and only"
              + "\ndeal with, temperatures between absolute zero and the "
              + "boiling point of water.");
      
      System.out.print("\n\nIf any temperature value does not satisfy the "
              + "necessary criteria, an error"
              + "\nmust be reported and the value must be ignored by the "
              + "program, which simply"
              + "\nasks for another value after reporting the error. In "
              + "addition, if the user"
              + "\ndoes not respond correctly when asked to choose the kind of"
              + " value to convert,"
              + "\nat that point the program also reports the error and "
              + "repeats the request."
              + "\n                                                             " 
              + "       Page 1 of 1" 
              + "\nPress Enter to continue ...");
      keyboard.nextLine();
    }


    /**
     * Prompts the user to enter a single character to choose whether to
     * convert a Fahrenheit or Celsius value, or to quit the program, and
     * then returns that value. If the value entered is not one of the
     * valid single characters, an error is reported and the user is asked
     * to try again. [Check the sample output file to see the required
     * format for the prompt and error message.]
     */
    private static char getRequestedAction()
    {
        //Variables
        System.out.print("\nWhat kind of temperature would you like to convert?");
        System.out.print("\nEnter f for Fahrenheit, c for Celsius, or q to quit: ");
        char decision;
        String decisionCheck;

        //Checks and confirms the requested action
        decisionCheck = keyboard.nextLine();
        if (decisionCheck.isEmpty() || decisionCheck.length() > 1)
        {
            System.out.print("\nError: Invalid response.\nTry again."
                    + "\nPress Enter to continue ...");
            keyboard.nextLine();
            decision = 'a';
        }
        else
        {
        decision = decisionCheck.charAt(0);
        switch(decision)
        {
            case 'f':
               {
                   fFromUser = true;
                   while (fFromUser == true)
                   {
                   TemperatureConversion2.getFahrenheitTemperatureFromUser();
                   }
                   break;
               }
            case 'c':
               {
                   cFromUser = true;
                   while (cFromUser == true)
                   {
                       TemperatureConversion2.getCelsiusValueFromUser();
                   }
                   break;
               }
            case 'q':
               {
                   System.out.print("\nQuit option chosen."
                           + "\nProgram now terminating."
                           + "\nPress Enter to continue ...");
                   keyboard.nextLine();
                   System.exit(0);
                   break;
               }
        default:
               {
                   System.out.print("\nError: Invalid response. \nTry again.");
                   System.out.print("\nPress Enter to continue ...");
                   keyboard.nextLine();
                   break;
               }
        }
        }
        return(decision);
    }
    /**
     * Gets a Fahrenheit temperature value from the user, entered
     * from the keyboard. The value must be valid, That is, it must
     * be a number that lies within the range -459.67..212.00.
     * If    it is not valid, the program outputs an error message and
     * asks the user to try again. [Check the sample output file to
     * see the required format for the prompt and error message.]
     */
    private static double getFahrenheitTemperatureFromUser()
    {
        System.out.print("\nEnter a Fahrenheit temperature in the "
                + "range " + FTEMPMIN + " to " + FTEMPMAX + ": ");
        fTemp = keyboard.nextDouble();
        keyboard.nextLine();
        if (fTemp < FTEMPMIN || fTemp > FTEMPMAX) 
        {
            System.out.print("\nError: Invalid Fahrenheit temperature."
                    + "\nTry again.\nPress Enter to continue ...");
            keyboard.nextLine();
        }
        else
        {
            TemperatureConversion2.celsiusFromFahrenheit(fTemp);
            fFromUser = false;
        }
    return(fTemp);
        //--Enter code here to complete this method body.
    }


    /**
     * Takes in a Fahrenheit temperature value as input and
     * returns the corresponding Celsius value, rounded to
     * two places after the decimal.
     */
    private static double celsiusFromFahrenheit
    (
        double fTemp //in
    )
    {
        cTemp = (((fTemp - 32) * 5) / 9);
        System.out.print("The corresponding Celsius value of Fahrenheit value "
                + String.format("%.2f", fTemp) + " is " 
                + String.format("%.2f", cTemp) + ".");
        System.out.print("\nPress Enter to continue ...");
        keyboard.nextLine();
    return(fTemp);
        //--Enter code here to complete this method body.
    }


    /**
     * Gets a Celsius temperature value from the user, entered from
     * the keyboard. The value must be valid, That is, it must be a
     * number that lies within the range -273.15..100.00. If it
     * is not valid, the program outputs an error message and asks
     * the user to try again. [Check the sample output file to see
     * the required format for the prompt and error message.]
     */
    private static double getCelsiusValueFromUser()
    {
        System.out.print("\nEnter a Celsius temperature in the range "
                           + CTEMPMIN + " to " + CTEMPMAX + ": ");
        cTemp = keyboard.nextDouble();
        keyboard.nextLine();
        if (cTemp < CTEMPMIN || cTemp > CTEMPMAX) 
        {
            System.out.print("\nError: Invalid Fahrenheit temperature."
                    + "\nTry again.\nPress Enter to continue ...");
            keyboard.nextLine();
        }
        else
        {
            TemperatureConversion2.fahrenheitFromCelsius(cTemp);
            cFromUser = false;
        }
    return(cTemp);
        //--Enter code here to complete this method body.
    }


    /**
     * Takes in a Celsius temperature value as input and
     * returns the corresponding Fahrenheit value, rounded
     * to two places after the decimal.
     */
    private static double fahrenheitFromCelsius
    (
        double cTemp //in
    )
    {
        fTemp = ((cTemp * 1.8) + 32);
        System.out.print("The corresponding Fahrenheit value of Celsius value "
                + String.format("%.2f", cTemp) + " is " 
                + String.format("%.2f", fTemp) + ".");
        System.out.print("\nPress Enter to continue ...");
        keyboard.nextLine();
    return(cTemp);
        //--Enter code here to complete this method body.
    }

}

