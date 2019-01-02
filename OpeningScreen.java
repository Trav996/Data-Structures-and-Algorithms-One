//OpeningScreen.java
//Barrett:Travelle:A00380824:csc122822
//Submission 04
//Temperature Conversion, Part 4

/*
 * The programs works accurately.
 */

import java.util.Scanner;
import java.lang.Object;

/**
 *A class to display an opening screen of identification information.
 */
public class OpeningScreen
{
    // ---------- Class Property ------------------------------------- //
    private Scanner kbd = new Scanner(System.in);

    // ---------- Program Method ------------------------------------- //

    /**
     * Displays three lines of identification information, indented by 
     * two tab widths from the left margin and centered (more or less) 
     * vertically on the screen, with a pause for the user to press Enter 
     * to continue at the end of the display. The screen is otherwise blank.
     */
    public void display()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\tBarrett:"
                + "Travelle:A00380824:csc122822");
        System.out.println("\t\tSubmission 04");
        System.out.println("\t\tTemperature Conversion,"
                + " Part 4\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("Press Enter to continue ... ");
        kbd.nextLine(); 
    }

    /**
     *A simple test driver for this class. It creates an object of 
     *this class and then displays it.
     */
    public static void main (java.lang.String[] args)
    {
        OpeningScreen screen = new OpeningScreen();
        screen.display();
    }

}//end class
