import java.io.*;
import java.util.Scanner;

public class SpellCheck
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		String file1 = args[0];
		String file2 = args[1];
		System.out.println(" ");

		File inputFile1 = new File(file1);
		Scanner infile1 = new Scanner(inputFile1);

		File inputFile2 = new File(file2);
		Scanner infile2 = new Scanner(inputFile2);

		compareFiles(infile1,infile2);
	}
    public static void compareFiles(Scanner infile1, Scanner infile2) 
            throws IOException
        {
            int counter = 1;
            String line1 = readFrom(infile1);
			String line2 = readFrom(infile2);
            while(line1 != null && line2 != null)
			{
                int answer = line1.compareTo(line2);
				if(answer != 0)
				{
                    System.out.println("Difference found in line " + counter);
					printLine(line1);
					printLine(line2);
                }
                if(infile1.hasNextLine() && infile2.hasNextLine())
                {
                    line1 = readFrom(infile1);
                    line2 = readFrom(infile2);
					counter++;
				}
                else
                    break;
            }
		}
    public static String readFrom(Scanner infile) throws IOException
    {
        if(infile.hasNextLine())
            return infile.nextLine();
        return null;
    }
    public static void printLine(String line)
    {
        System.out.println(line);
	}
}

    //ArrayList links;
 
//while((line=bReader.readLine()) != null){
//for(String s : links){
//if(line.equals(s)){
//System.out.println(s+" identical match found in the text file!");
//break; // breaks the enhanced for loop to search the next line
//}
//}
//}
//}

//String line;
//String link = "your String to search for";
//File file = new File("PATH");
//BufferedReader bReader = new BufferedReader(file);
 
//while((line=bReader.readLine()) != null){
//if(line.equals(link)){
//System.out.println(link+" identical match found in the text file!");
//}
//}

