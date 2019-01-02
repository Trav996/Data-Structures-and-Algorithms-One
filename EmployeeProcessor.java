//EmployeeProcessor.java
//Barrett:Travelle:A00380824:csc34114
//Submission 06
//Processing Employees

/*
 * When I first created the compareTo method for the names 
 * and tested it, it worked perfectly, but I am not 
 * sure what changed. Now when I run the program it does 
 * not sort as accurately for the required conditions.
 */

import java.util.*;
import java.io.*;

/**
 * A class to process a list of employee information.
 * @author Travelle Barrett
 */
public class EmployeeProcessor
{
    private static Scanner inputStream = null;

    /**
     * Main method to test program.
     */ 
    public static void main(String[] args)
    {
        if(args.length > 1)
        {
            String file = args[0];
            String storedType = args[1];
            getFile(file);
            List<Employee> empList = new ArrayList<>();
            Employee employee;
            if(args.length > 2)
            {
                System.out.println("\nError:\nToo many command-line inputs."
                        +"\nProgram now terminating.");
                Utils.pause();
            }
            if(args.length == 2 && !args[1].equals("bylastname") 
                    || !args[1].equals("bygender") 
                    || !args[1].equals("byhiredate") 
                    || !args[1].equals("bysalary"))
            {
                System.out.println("\nError:\nProcessing command not " +
                        "understood."+ "\n" +"Program now terminating.");
                Utils.pause();
            }
            while(inputStream.hasNextLine())
            {
                String line = inputStream.nextLine();
                String[] employeeData = line.split(",");
                employee = new Employee(employeeData[0], 
                employeeData[1].charAt(0),
                Integer.parseInt(employeeData[2]), 
                Double.parseDouble(employeeData[3]));
                if(storedType.equals("bylastname"))
                {
                    if(empList.isEmpty())
                    {
                        empList.add(employee);
                    } 
                    else 
                    {
                        for(int i = 0; i < empList.size(); i++)
                        {
                            if((employee.compareTo(empList.get(i).getName())>
                                        0)|| (employee.compareTo(empList.
                                                get(i).getName()) == 0))
                            {
                                empList.add(i + 1, employee);
                                break;
                            } 
                            else 
                            {
                                empList.add(i, employee);
                                break;
                            }
                        }
                    }
                }
                else if(storedType.equals("bygender"))
                {
                    if(empList.isEmpty())
                    {
                        empList.add(employee);
                    } 
                    else 
                    {
                        for(int i = 0; i < empList.size(); i++)
                        {
                            if((employee.compareTo(empList.get(i).getGender())
                                    < 0)|| (employee.compareTo(empList.get
                                            (i).getGender()) == 0))
                            {
                                empList.add(i + 1, employee);
                                break;
                            } 
                            else 
                            {
                                empList.add(i, employee);
                                break;
                            }
                        }
                    }
                }
                else if(storedType.equals("byhiredate"))
                {
                    if(empList.isEmpty())
                    {
                        empList.add(employee);
                    } 
                    else 
                    {
                        for(int i = 0; i < empList.size(); i++)
                        {
                            if((employee.compareTo(empList.get(i).
                                            getHireDate())< 0)
                                    || (employee.compareTo(empList.
                                            get(i).getHireDate()) == 0))
                            {
                                empList.add(i + 1, employee);
                                break;
                            } 
                            else 
                            {
                                empList.add(i, employee);
                                break;
                            }
                       }
                    }
                }
                else if(storedType.equals("bysalary"))
                {
                    if(empList.isEmpty())
                    {
                        empList.add(employee);
                    }
                    else 
                    {
                        for(int i = 0; i < empList.size(); i++)
                        {
                            if((employee.compareTo(empList.get(i).getSalary())
                                    < 0)|| (employee.compareTo(empList.get
                                            (i).getSalary()) == 0))
                            {
                                empList.add(i + 1, employee);
                                break;
                            } 
                            else 
                            {
                                empList.add(i, employee);
                                break;
                            }
                        }
                    }
                }
            }
            if(storedType.equals("bylastname"))
            {
                System.out.println("\nHere are the employees, sorted by "
                        +"last name:");
            }
            if(storedType.equals("bygender"))
            {
                System.out.println("\nHere are the employees, sorted by "
                        +"gender:");
            }
            if(storedType.equals("byhiredate"))
            {
                System.out.println("\nHere are the employees, sorted by "
                        +"hire date:");
            }
            if(storedType.equals("bysalary"))
            {
                System.out.println("\nHere are the employees, sorted by "
                        +"salary:");
            }
            for( int k = 0; k < empList.size(); k++)
            {
                System.out.println(empList.get(k).toString());
            }
        }
        else
        {
            displayUserInfo();
        }
    }
    
    /**
     * Method to get and open a file.
     * @param file The name of the file.
     */ 
    public static void getFile
    (
         String file //in
    )
    {
        try
        {
            inputStream = new Scanner(new File(file));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nError:\nFile " + file + " not found." 
                    +".\nProgram now terminating.\n");
            Utils.pause();
            System.exit(0);
        }
    }

    /**
     * Method to display student identification and program description.
     */ 
    public static void displayUserInfo()
    {
        OpeningScreen displayScreen = new OpeningScreen("Barrett:Travelle:"
                +"A00380824:CSC34114", "Submission 06", "Processing "
                +"Employees");
        displayScreen.display();
        TextItems textItems = null;
        try
        {
            textItems = new TextItems
            (
                EmployeeProcessor.class.getResourceAsStream
                ("EmployeeProcessor.txt")
            );
        }
        catch (NullPointerException e) 
        {
            System.out.println("\nError: NullPointerException thrown.");
            System.out.println("Could not open file EmployeeProcessor.txt."
                + "\nProgram now terminating.");
            Utils.pause();
            return;
        }
        catch (Exception e) 
        {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Could not open file EmployeeProcessor.txt."
                + "\nProgram now terminating.");
            Utils.pause();
            return;
        }
        textItems.displayItem("ProgramDescription");
    }
    
}//end class EmployeeProcessor
