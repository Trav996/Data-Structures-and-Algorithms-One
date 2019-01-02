//Decoder.java
//Barrett:Travelle:A00380824:csc34114
//Submission 01
//Decoding Encoded Textfiles

/*
 * This program performs all its functions accurately.
 */

import java.util.Scanner;
import java.io.*;

/**
 * A class to decode previously encoded textfiles, one file per run, and
 * write the encoded text out to an output textfile. The names of the
 * input and output files are both read from the command line. The
 * encoding scheme is described elsewhere.
 * @author Travelle Barrett
 */
public class Decoder
{
    // ---------- Private Data Members -------------------------------- //
    private static Scanner inputStream = null;
    Scanner keyboard = new Scanner(System.in);
    PrintWriter output;
    
    // ---------- Constructors -------------------------------- //
    public Decoder()
    {
        System.out.print("\n\n\n\n\n\n\n\n\t\tBarrett:Travelle:"
                + "A00380824:csc34114\n\t\tSubmission 01" 
                + "\n\t\tDecoding Encoded Textfiles");
        System.out.print("\n\n\n\n\n\n\n\n\n\nPress Enter to "
                +"continue ...");
        keyboard.nextLine(); //pause
        
        System.out.print("\nThis program decodes a previously-encoded "
                +"file and writes the plain text form\nof the file out "
                +"to an output file.\n\nThe program takes two "
                +"command-line parameters:\n\n1. The first "
                +"command-line parameter must be the name of the input "
                +"file, and\n   if the file is not in the current "
                +"directory it may include the path to the\n   file. "
                +"This is the file containing plain text.\n2. The second "
                +"command-line parameter must be the name of the output "
                +"file, and\n   if the file is to be written to a "
                +"location other than the current directory,\n   it may "
                +"include the path to the file. This is the file that "
                +"will contain the\n   encoded text.\n\nThe program "
                +"performs two error checks to make sure that both the "
                +"input file\nand the output file exist and can be "
                +"opened for reading (in the case of input)\nand writing "
                +"(in the case of output). If either check fails, a "
                +"suitable message\nwill be displayed, followed by a "
                +"pause, after which the program will terminate.\n\n"
                +"The program does no other error checking, so it is the "
                +"user's responsibility to\nmake sure that the "
                +"above-listed parameters are both present, correct, and "
                +"given\nin the correct order. If this is not the case, "
                +"the program is not responsible\nfor what happens."
                +"\n\t\t\t\t\t\t\t\t  Screen 1 0f 1");
        System.out.print("\nPress Enter to continue ..."); //pause
        keyboard.nextLine();
    }

    public Decoder(String decoder, String output)
    {
        getFile(decoder);
        createFile(output);
        readFromFile(decoder, output);
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
            Decoder open = new Decoder();    
        }
        else
        {
            Decoder open2 = new Decoder(args[0], args[1]);
        }    
    }//end main
    
    // ---------- Helper Methods -------------------------------- //
    /**
     * Method to get and open file.
     * @param fileName The name of the file.
     */ 
    public void getFile
    (
     String fileName
    )
    {
        try
        {
            inputStream = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nProblem opening input file " + fileName
                    + ".\nProgram now terminating.");
            System.out.print("\nPress Enter to continue ..."); //pause
            keyboard.nextLine();
            System.exit(0);
        }
    }
    /**
     * Method to create file.
     * @param outputFileName The output file.
     */ 
    public void createFile
    (
     String outputFileName
    )
    {
        try
        {
            output = new PrintWriter(new File(outputFileName));
        }
        catch(FileNotFoundException e)
        {
            e.getMessage();
        }
    }
    /**
     * Method to read from the file.
     */ 
    public void readFromFile(String inFile, String outFile)
    {
        String line;
        while(inputStream.hasNextLine())
        {
           line = inputStream.nextLine();
           decodeLine(line);
           System.out.print("\nThe input file "+ inFile 
                   +" has been decoded and output to the file "+ outFile +".\n");
           System.out.print("\nPress Enter to continue ..."); //pause
           keyboard.nextLine();
        }
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
            n = n - 123;
            writeCharacter(n); //method call
       }
       output.close(); //close output stream.
    }
    /**
     * Method to cast int to char and output results.
     * @param n1 Integers on each line.
     */ 
    public void writeCharacter
    (
     int n1
    )
    {
        char result = (char)n1;
        output.print(result);
    }
}//end class Decoder
