//EncoderDecoder.java
//Barrett:Travelle:A00380824:csc34114
//Submission 03
//Encoding and Decoding Textfiles

/*
 * This program performs all its functions accurately.
 */

import java.util.Scanner;
import java.io.*;

/**
 * A class to encode a file of plain text and writes the encoded 
 * text out to an output file.
 * @author Travelle Barrett
 */
public class EncoderDecoder
{
    // ---------- Private Data Members -------------------------------- //
    private static Scanner inputStream = null;
    Scanner keyboard = new Scanner(System.in);
    PrintWriter output;   
    // ---------- Constructors -------------------------------- //
    public EncoderDecoder()
    {
        userInfo();      
    }
    //public EncoderDecoder(String input, String output)
    //{
        //getFile(input);
        //createFile(output);
       // readFromFile(input, output);
    //}
    // ---------- Main Method ----------------------------------- //
    /**
     * Main method to test program.
     */ 
    public static void main(String[] args) 
    { 
        if (args.length == 0)
        {
            //Display opening screen and program info
            EncoderDecoder open = new EncoderDecoder();    
        }
        if(args.length != 3)
        {
            System.out.print("\nError: Exactly three command-line "
                    +"inputs required.\n" + "Program now terminating.\n");
            Utils.pause();
        }
        else if(args[0].equalsIgnoreCase("e") || args[0].
                equalsIgnoreCase("d"))
        {
            getFile(args[1]);
            createFile(args[2]);
            readFromFile(args[1],args[2]); 
        }
        else
        {
            System.out.print("\nError: Bad first parameter (must be e "
                    +"or d).\nProgram now terminating.");
            Utils.pause();         
        }    
    }//end main    
    // ---------- Helper Methods -------------------------------- //
    /**
     * Method to get and open file.
     * @param fileName The name of the file.
     */ 
    public void getFile
    (
         String fileName //in
    )
    {
        try
        {
            inputStream = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nProblem opening input file " + fileName
                    + ".\nProgram now terminating.\n");
            Utils.pause();
            System.exit(0);
        }
    }
    /**
     * Method to create file.
     * @param outputFileName The output file.
     */ 
    public void createFile
    (
         String outputFileName //in
    )
    {
        try
        {
            output = new PrintWriter(new File(outputFileName));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nProblem opening output file " + outputFileName
                    + ".\nProgram now terminating.\n");
            Utils.pause();
            System.exit(0);          
        }
    }
    /**
     * Method to read from the file.
     * @param inFile plain text file.
     * @param outFile encoded file.
     */ 
    public static void readFromFile
    (
         String inFile, //in
         String outFile //in
    )
    {
        String line;
        while(inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            decodeLine(line);    
        }
        output.close();//close output stream.
        System.out.print("\nThe input file "+ inFile 
                   +" has been decoded and output to the file "
                   + outFile +".\n");
       Utils.pause();           
    }

    /**
     * Method to decode file line by line.
     * @param line Represents lines in the file.
     */
    public void decodeLine
    (
     String line
    )
    {
        int operand = 0;
        char [] anArray = new char[3];
        while (operand < line.length())
        {
            for(int i = 0; i< 3; i++)
            {
                anArray[i] = line.charAt(operand);
                operand++;
            }
            
            String str = new String(anArray);
            int n = Integer.parseInt(str);
            if(n == 433)
            {
                output.println();
            }
            else
            {
                n = n - 123;
                writeCharacter(n); //method call
            }    
       }
    }
    /**
     * Method to encode file line by line.
     * @param myString Represents lines in the file.
     */
    public void encodeLine
    (
         String myString //in
    )
    {
        int operand = 0;
        
        while (operand < line.length())
        {
            char myChar = line.charAt(operand);
            int ascii = (int)myChar;
            if(operand % 60 == 0)
            {
                output.println();
            }
            else
            {
                ascii = ascii + 123;
                writeInteger(ascii); //method call    
            }               
        }
        output.print(433);
    } 

    /**
     * Method to display student identification and program description.
     */ 
    public static void userInfo()
    {
        OpeningScreen displayScreen = new OpeningScreen("Barrett:Travelle:"
                +"A00380824:CSC34114", "Submission 02", "Encoding Files of "
                +"Plain Text");
        displayScreen.display();
        TextItems textItems = null;
        try
        {
            textItems = new TextItems
            (
                EncoderDecoder.class.getResourceAsStream("EncoderDecoder.txt")
            );
        }
        catch (NullPointerException e) 
        {
            System.out.println("\nError: NullPointerException thrown.");
            System.out.println("Could not open file EncoderDecoder.txt."
                + "\nProgram now terminating.");
            Utils.pause();
            return;
        }
        catch (Exception e) 
        {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Could not open file EncoderDecoder.txt."
                + "\nProgram now terminating.");
            Utils.pause();
            return;
        }
        textItems.displayItem("ProgramDescription");
    }
    public void writeCharacter
    (
         int n1 //in
    )
    {
        char result = (char)n1;
        output.print(result);
    }
    /**
     * Method to cast int to char and output results.
     * @param n1 Integers on each line.
     */ 
    public void writeInteger
    (
         int n1 //in
    )
    {
        
        output.print(n1);
    }
}//end class EncoderDecoder
