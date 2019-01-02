//ProcessNames.java
//Barrett:Travelle:A00380824:csc122822
//Submission 06
//Processing Names

/*
 *The program works accurately.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * A class for displaying client-supplied first names
 * and last names and sorting them according to
 * the first command-line argument condition.
 * @author Travelle Barrett
 */ 
public class ProcessNames 
{
    // ---------- Class Fields ------------------------------------- //
    private String firstName;
    private String lastName;

    // ---------- Constructor ------------------------------------- //
    /**
     * A constructor which creates a ProcessNames object with 
     * client-supplied first names and last names to be displayed.
     * @param lastName The last name.
     * @param firstName The first name.
     */ 
    public ProcessNames (String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // ---------- Getters and Setters ------------------------------ //
    /**
     * Returns the first name.
     */ 
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the last name.
     */ 
    public String getLastName()
    {
        return lastName;
    }

    /**
     * This method assigns a new value to variable firstName.
     * @param fName This is the requested last name.
     */ 
    public void setFirstName(String fName)
    {
        this.firstName = fName;
    }
    /**
     * This method assigns a new value to variable lastName.
     * @param lName This is the requested last name.
     */ 
    public void setLastName(String lName)
    {
        this.lastName = lName;
    }

    // ----------------- More Methods ----------------------------- //
    @Override
    /**
     * A method to return a string representation of the object.
     */ 
    public String toString()
    {
        return firstName + " " + lastName;
    }

    /**
     * A method to change the original format of the names at the 
     * command-line to a new format which takes the names in the form
     * of "Last, First".
     * @param input The name the user inputs at the command-line.
     */ 
    public String changeNameFormat(String input)
    {
        this.firstName = input.substring(0, input.indexOf(" "));
        this.lastName = input.substring(input.indexOf(" ") 
                + 1, input.length());
        return this.lastName + ", " + this.firstName;
    }

    /**
     * This method sorts an array of names.
     * @param arr An array of String arguments.
     */ 
    public static void selectionSort(String[] arr)
    {
        for (int i = arr.length - 1; i >= 0; i--)		
        {
            int highestIndex = i;				
		for (int j = i; j >= 0; j--)										
		{
            if(arr[j].compareTo(arr[highestIndex]) > 0)
                highestIndex = j;		
		}

		String names = arr[i];  // swap the values
		arr[i] = arr[highestIndex];
		arr[highestIndex] = names;

        }
    }
    public static void reverse(String[] input) 
    { 
        int last = input.length - 1; 
        int middle = input.length / 2; 
        for (int i = 0; i <= middle; i++) 
        { 
            String temp = input[i]; //swap the values
            input[i] = input[last - i]; 
            input[last - i] = temp; 
        } 
    }
 
    /**
     * A method to display the names in the order of input 
     * at the command-line.
     * @param names This is an array of names.
     */ 
    public void displayOriginalNames(String [] names)
    {
        System.out.println("\nHere is a list of the names you read in: ");
        for (int n = 1; n < names.length; n++)
        {
            System.out.println(names[n]);
        }
        pause();
    }

    /**
     * A method to pause the program and wait for user to press Enter.
     */
    public static void pause()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Press Enter to continue ... ");
        keyboard.nextLine();
    }   
    
    /**
     * Tests the ProcessNames class with input from the command line.
     * If there are no command-line inputs, the opening screen and the
     * program description screen are displayed. If the first command-
     * line input is "orig", only the names in the order of input is
     * displayed. If the first command-line input is "sort", then the
     * original order is displayed then it is sorted alphabetically. If
     * the first command line input is "slst", the original order is
     * displayed, then it is displayed in the format "Last, First" sorted
     * by Last. If the first command-line input is "sfst" the original
     * order is displayed, then it is displayed in the format "Last, First"
     * sorted by First in reverse order. If the first command-line input
     * does not meet these conditions, the original names are displayed
     * (if any) and outputs the following message:
     * Error: Bad first parameter.
     * Unable to determine requested action.
     * Program now terminating
     * @param args The array of command-line inputs.
     */ 
    public static void main(String[] args)
    {
        OpeningScreen openingScreen = new OpeningScreen();
        ProgramDescription description = new ProgramDescription();
        
        if (args.length == 0)
        {
            openingScreen.displayIdentificationInfo();
            description.displayProgramDescription();
        }

        else if (args.length > 0 && args[0].equals("orig"))
        {
            ProcessNames names = new ProcessNames(args[0], args [1]);
            names.displayOriginalNames(args);
        }

        else if (args.length > 0 && args[0].equals("sort"))
        {
            ProcessNames names = new ProcessNames(args[0], args [1]);
            names.displayOriginalNames(args);
            System.out.println("\nAnd here is a sorted list of the " 
                    + "names as read in: ");
            for (int s = 0; s < args.length - 1; s++)
            {
                Arrays.sort(args);
                System.out.println(args[s]) ;
            }
            pause();     
        }

        else if (args.length > 0 && args[0].equals("slst"))
        {
            ProcessNames names = new ProcessNames(args[0], args [1]);
            names.displayOriginalNames(args);
            System.out.println("\nAnd here is a list of the names sorted "
                    +"by last name,\ndisplayed in the format Last, First: ");
            for (int s = 0; s < args.length - 1; s++)
            {
                reverse(args);
                System.out.println(names.changeNameFormat(args[s]));
            }
            pause();
        }

        else if (args.length > 0 && args[0].equals("sfst"))
        {
            ProcessNames names = new ProcessNames(args[0], args [1]);
            names.displayOriginalNames(args);
            System.out.println("\nAnd here is a list of the names sorted "
                    +"in reverse order by first name,\ndisplayed in the "
                    +"format Last, First: ");
            for (int s = 0; s < args.length - 1; s++)
            {
                selectionSort(args);
                System.out.println(names.changeNameFormat(args[s]));
            }
            pause();
        }
        else
        {
            ProcessNames names = new ProcessNames(args[0], args [1]);
            names.displayOriginalNames(args);
            System.out.println("\nError: Bad first parameter."
                    +"\nUnable to determine requested action."
                    +"\nProgram now terminating");
            pause();
        }
        
    
    }//end main

}//end ProcessNames.java
