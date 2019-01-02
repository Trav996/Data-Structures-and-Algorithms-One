//IllustrateInheritance.java
//Barrett:Travelle:A00380824:csc122822
//Submission 07
//Illustrating Inheritance with Person, Student and Undergraduate

/*
 *The program works accurately.
 */

import java.util.Scanner;

/**
 * A class to illustrate inheritance with Person, Student and Undergraduate.
 */ 
public class IllustrateInheritance
{  
    public static void pause()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Press Enter to continue ... ");
        keyboard.nextLine();
    }
    
    public static void main(String[] args)
    {
        if (args.length == 0)
        { 
            Person person = new Person();  
            person.writeOutput();
            pause();
            System.out.println();
            Student student = new Student();
            student.writeOutput();
            pause();
            System.out.println();
            Undergraduate undergrad = new Undergraduate();
            undergrad.writeOutput();
            pause();
        }
        
        if (args.length == 1 && args[0].equals("getinfo"))
        {
            OpeningScreen os = new OpeningScreen();
            os.displayIdentificationInfo();
            ProgramDescription pd = new ProgramDescription();
            pd.display();
        }

        if (args.length == 1 && !args[0].equals("getinfo"))
        {
            Person person1 = new Person("" + args[0]);
            person1.setName(args[0]);
            person1.writeOutput();
            pause();
        }

        if (args.length == 2)
        {
            int n = Integer.parseInt(args[1]);
            Student student1 = new Student(args[0],n);
            student1.writeOutput();
            pause();
        }
        
        if (args.length == 3)
        {
            int n1 = Integer.parseInt(args[1]);
            int n2 = Integer.parseInt(args[2]);
            Undergraduate undergrad1 = new Undergraduate(args[0], n1, n2);
            undergrad1.writeOutput();
            pause();
        }

        if (args.length == 4)
        {
            System.out.print("Error: Too many input parameters."
                    +"\nProgram now terminating.\n");
            pause();
        }
    }
}
