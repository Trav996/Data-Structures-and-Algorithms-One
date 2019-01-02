//ConverterTest.java
//Barrett:Travelle:A00380824:csc122822
//Submission 04
//Temperature Conversion, Part 4

/*
 * The programs works accurately.
 */

import java.lang.Object;
import java.util.Scanner;

/**
 * A driver class for the OpeningScreen, ProgramDescription,
 * ActionRequest and Converter classes.
 */
public class ConverterTest
{
    /**
     * This main() function first displays the opening screen,
     * then the program description, and then permits the user
     * to convert any number of temperature values from
     * Fahrenheit to Celsius, or vice versa, displaying each
     * number in both representations after each conversion.I
     */
    public static void main (java.lang.String[] args)
    {
        // ---------- Create Objects ------------------------------------ //
        Scanner kbd = new Scanner(System.in);
        OpeningScreen openingScreen = new OpeningScreen();
        ProgramDescription description = new ProgramDescription();
        ActionRequest aRequest = new ActionRequest();
        Converter c = new Converter();
        
        // ---------- Method Calls ------------------------------------- //
        openingScreen.display();
        description.display();

        do
        {
        aRequest.readRequest();
        
        switch (aRequest.getRequest())
        {
            case 'Q':
            case 'q':
                System.out.print("\nQuit option chosen."
                        +"\nProgram now terminating."
                        +"\nPress Enter to continue ...");
                kbd.nextLine();
                System.exit(0);
                break;
                
            case 'F':
            case 'f':
                c.readFahrenheitTemperature();
                c.displayBothValues();
                break;
                
            case 'C':
            case 'c':
                c.readCelsiusTemperature();
                c.displayBothValues();
                break;
                
            default: //Do nothing
        }
        
        }
        while (true); //Program loop
    
    }//end main

}//end ConverterTest
