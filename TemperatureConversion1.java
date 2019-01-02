//TemperatureConversion1.java
//Barrett:Travelle:A00380824:CSC122822
//Submission 01
//Temperature Conversion, Part 1

/*
All the conditions of the program are met, and the programs works accurately.
*/

import java.util.Scanner;

/**
 * This class contains a complete program, with just a main() method,
 * for converting Fahrenheit temperatures to Celsius temperatures.
 * The user may perform as many conversions as desired during a single
 * run of the program.
 */
public class TemperatureConversion1
{
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        
        //Variable declarations
        double temp;     //temperature value
		String answer;   //user input
        
        //Display identification information and pause
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\tBarrett:"+
                "Travelle:A00380824:csc122822"); 
        System.out.println("\t\tSubmission 01"); 
        System.out.println("\t\tTemperature Conversion,"+
                " Part 1\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("Press Enter to continue ... ");
        kbd.nextLine();

        //Display program description and pause
        System.out.println("\nThis program allows the user to convert a Fahrenheit "+
                "temperature entered by the"+"\nuser to its equivalent Celsius value. "+
                "It then displays, on the standard output,"+"\na sentence giving both the "+
                "Fahrenheit temperature entered and its corresponding"+"\nCelsius value." + 
                "\n\nFahrenheit temperatures are entered as real number values, which may " +
                "or may not\ncontain a decimal point. A valid Fahrenheit temperature value "+ 
                "is one that lies\nin the range -459.67 to 212.00 (absolute zero to the "+
                "boiling point of water).\n\nThe program can convert any number of values "+
                "on any given run. On each pass\nthe user must either choose to quit (by "+
                "entering a lowercase q and pressing\nEnter), or choose to convert another "+
                "value (by simply pressing Enter). If the\nuser enters anything else at "+
                "this point, the program reports an error\nand allows the user to try again."+
                "\n\nWhen the conversion option is chosen, a valid Fahrenheit temperature "+
                "in the\nrequired rantge is then expected as input. If the temperature "+ 
                "entered does not\nfall within the required range of values, an error "+ 
                "must be reported and the\nvalue must be ignored by the program, which "+ 
                "simply carries on after reporting\nthe error. The program is not "+ 
                "responsible for dealing with the kind of error\nthat occurs if anything "+
                "other than a real number is entered when a valid\nFahrenheit temperature "+
                "is expected.\n\t\t\t\t\t\t\t\t    Page 1 of 1");
        
        System.out.print("\nPress Enter to continue ... ");
        kbd.nextLine();

        //Program loop
        while(true)
        {	
			System.out.print("\nEnter q to quit, or just press Enter "+
                    "to convert a value: ");
			answer = kbd.nextLine();
			
			//If the enter key is pushed, answer will be empty and this answer will 
            //be satisfied
			if(answer.isEmpty())
			{
				System.out.print("\nEnter a Fahrenheit temperature in the range "+
                        "-459.67 to 212.00: ");
				temp = kbd.nextDouble();
				kbd.nextLine();  // Consume newline left-over to prevent skipping

				if(temp <= 212.00 && temp >= -459.67) //check if value in range
				{
					System.out.println("The Fahrenheit temperature entered was "+temp+" degrees.");
					temp = (temp-32)*5/9; //Convert to celsius
					System.out.printf("The corresponding Celsius temperature is %.2f degrees.\n"
                            , temp) ;
				    System.out.print("Press Enter to continue ...");
                    kbd.nextLine();
                }
				else
					System.out.println("\nError: Fahrenheit temperature out of range.\nTry again."
                            + "\nPress Enter to continue ...");
					
			}
			
			//if char q is entered condition will be satisfied
			//Note, this will only occur if input is a single char
			else if(answer.charAt(0) == 'q' && answer.length() == 1)
			{
				System.out.println("\nQuit option chosen.\nProgram now terminating."+
                        "\nPress Enter to continue ...");
				System.exit(0);
			}

			else
				System.out.println("\nError: Invalid response.\nTry again."+
                        "\nPress Enter to continue ...");
		}//end loop
          
        
        
    
    }//end main
}//end temperatureconversion1
        

        
