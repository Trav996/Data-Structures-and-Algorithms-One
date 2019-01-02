//Encoder.java
//Barrett:Travelle:A00380824:csc34114
//Submission 02
//Encoding Files of Plain Text

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
public class Encoder
{
    // ---------- Private Data Members -------------------------------- //
    private static Scanner inputStream = null;
    Scanner keyboard = new Scanner(System.in);
    PrintWriter output;   
    // ---------- Constructors -------------------------------- //
    public Encoder()
    {
        userInfo();      
    }
    public Encoder(String encoder, String output)
    {
        getFile(encoder);
        createFile(output);
        readFromFile(encoder, output);
    }
    // ---------- Main Method ----------------------------------- //
    /**
     * Main method to test program.
     */ 
    public static void main(String[] args) 
    { 
        if (args.length == 0)
        {
            //Display opening screen and program info
            Encoder open = new Encoder();    
        }
        else
        {
            Encoder open2 = new Encoder(args[0], args[1]);
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
    public void readFromFile
    (
         String inFile, //in
         String outFile //in
    )
    {
        String line;
        while(inputStream.hasNextLine())
        {
           line = inputStream.nextLine();
           encodeLine(line);
           System.out.print("\nThe input file " + inFile 
                   +" has been encoded and output to the "
                   +"file "+ outFile +".\n"); 
           Utils.pause();
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
        while (inputStream.hasNextLine())
        {
            myString = inputStream.nextLine();
            
            for(int i = 0; i< myString.length(); i++)
            {
                for(int j = 0; j < myString.length(); j++)
                {
                    myString += myString.charAt(j);
                }
                final int FUDGE_FACTOR = 123;
                int asciiCode = Integer.parseInt(myString);
                asciiCode += FUDGE_FACTOR;
                writeCharacter(asciiCode);
            }
       final int MAX_CHARS_PER_LINE = 20;
       final int NEWLINE_CHAR = 433;
       output.print(NEWLINE_CHAR);     
       }
       output.close(); //close output stream.  
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
                Encoder.class.getResourceAsStream("Encoder.txt")
            );
        }
        catch (NullPointerException e) 
        {
            System.out.println("\nError: NullPointerException thrown.");
            System.out.println("Could not open file Encoder.txt."
                + "\nProgram now terminating.");
            Utils.pause();
            return;
        }
        catch (Exception e) 
        {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Could not open file Encoder.txt."
                + "\nProgram now terminating.");
            Utils.pause();
            return;
        }
        textItems.displayItem("ProgramDescription");
    }
    public void writeCharacter
    (
     int n1
    )
    {
        char result = (char)n1;
        output.print(result);
    }
}//end class Encoder
