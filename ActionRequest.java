//ActionRequest.java
//Barrett:Travelle:A00380824:csc122822
//Submission 04
//Temperature Conversion, Part 4

/*
 * The programs works accurately.
 */

import java.util.Scanner;
import java.lang.Object;

/**
 * A class to handle user interaction when the user is 
 * choosing whether to perform a Fahrenheit to Celsius
 * conversion, or a Celsius to Fahrenheit conversion.
 */
public class ActionRequest
{
    // ---------- Class Properties ------------------------------------- //
    private Scanner kbd = new Scanner(System.in);
    private char request;
    private String answer;
    private int invalidCount;
   
    // ---------- Program Methods ------------------------------------- //
    
    /**
     * Prompts the user for, and then reads from the user, 
     * a request for action.The input must be a case-insensitive f, c or 
     * q, and the user has three attempts to enter one of these values. 
     * Depending on the situation when an invalid entry is made, an error
     * message is displayed.
     */

    public void readRequest() 
   {
       invalidCount = 2; //invalid tries starts at 2.
       do
       {
           System.out.print("\nWhat kind of value would you like to convert?"
                   + "\nEnter f (or F) for Fahrenheit, c (or C) for Celsius,"
                   + " or q (or Q) to quit: ");
           answer = kbd.nextLine();
           
           if (answer.isEmpty() || answer.length() > 1)
           {
               request = 't'; //request is invalid
           }
           if (answer.equalsIgnoreCase("q") || answer.equalsIgnoreCase("f")
                    || answer.equalsIgnoreCase("c"))
           {
               invalidCount = -3;   
           }
           else if (invalidCount == 0)
           {
               System.out.print("\nSorry, but you are out of tries."
                       + "\nThe quit option will now be supplied."
                       + "\nPress Enter to continue ...");
               kbd.nextLine();
               invalidCount--;
               answer = "q";
           }
           else  
           {
           if(invalidCount == 1)
           {
               System.out.print("\nError: Invalid response.\nTry again. "
                       + "(You have "+ invalidCount +" try left.)"
                       + "\nPress Enter to continue ...");
               kbd.nextLine();
               invalidCount--; //decrements number of invalid tries by 1.
               continue; //goes back to loop
           }
           else
           {
               System.out.print("\nError: Invalid response.\nTry again. "
                       + "(You have "+ invalidCount +" tries left.)"
                       + "\nPress Enter to continue ...");
               kbd.nextLine();
               invalidCount--; //decrements number of invalid tries by 1.
               continue; //goes back to loop
           }
           }
       }
       while (invalidCount >= 0); //program loop
   }
            
    /**
     *Returns the request for action.
     */
    public char getRequest()
    {
        return request = answer.charAt(0); //returns the first character
    }
    
    /**
     * A simple test driver for this class. It calls the readRequest() 
     * method to get a request for action from the user, and then displays 
     * the result of that request.
     */
    public static void main (java.lang.String[] args)
    {
        // ---------- Method Calls ------------------------------------- //
        ActionRequest aRequest = new ActionRequest();
 
        aRequest.readRequest(); 
        System.out.println("The requested action was " 
                + aRequest.getRequest() + ".");  
    }      

}//end class


