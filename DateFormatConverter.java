//DateFormatConverter.java
//Betschart:Nicolas:A00414388:csc122823
//Submission 08
//Converting Date Formats

import java.util.Scanner;

/*
 * This program is working.
 */

public class DateFormatConverter
{ 
    public static String month = null;
    public static String day = null;
    public static final int MIN_DAY = 1;
    public static int maxDay;
    
    // Main Class
    public static void main (String args[])
    {         
        Scanner keyboard = new Scanner(System.in);
        if (args.length == 0)
        {
            OpeningScreen opening = new OpeningScreen();
            opening.display();
            ProgramDescription description = new ProgramDescription();
            description.display();
        }
        else
        {
            try
            {     
                if (!args[0].contains("/"))
                    throw new BadInputException("Bad input: "
                        + "The / separator is missing. ");
                String[] parts = args[0].split("/", -1);
                month = parts[0];
                day = parts[1];
                if (month.length() > 2 || month.isEmpty())
                    throw new BadInputException("Bad input: Exactly one or two"
                        + " digits must precede the / separator. "); 
                else if (day.length() > 2 || day.isEmpty())
                    throw new BadInputException("Bad input: Exactly one or two"
                        + " digits must follow the / separator. ");
                char monthC1 = month.charAt(0);
                char monthC2 = month.charAt(1);
                if (Character.isLetter(monthC1) || Character.isLetter(monthC2))
                    throw new BadInputException("Bad input: The month value "
                        + "contains non-digits. ");
                char dayC1 = day.charAt(0);
                char dayC2 = day.charAt(1);
                if (Character.isLetter(dayC1) || Character.isLetter(dayC2))
                    throw new BadInputException("Bad input: The day value "
                        + "contains non-digits. ");
                DateFormatConverter converter = new DateFormatConverter();
                converter.maximumDay();
                String maxDayS = Integer.toString(maxDay);
                String dayRange = "1.." + maxDayS;
                int date = Integer.parseInt(day);
                int monthNumber = Integer.parseInt(month);
                if (monthNumber > 12 || monthNumber < 1)
                    throw new MonthException("\n" + monthNumber + " is an "
                        + "invalid month number (must be a number in 1..12).");
                else if (date < MIN_DAY || date > maxDay)
                    throw new DayException("\nBad day: Day value " + day
                        + " is invalid for month number " + month + ". "
                        + "\nDay must lie in the range " + dayRange + ".\n");

                System.out.println("\n" + monthNumber + "/" + day + " is " 
                    + converter.getMonth() + " " + day);
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.print("Press Enter to continue ... ");
                keyboard.nextLine();
            }
        }
    }

    public String getMonth()
    {
        switch (Integer.parseInt(month))
        {
            case 1: month = "January"; break;
            case 2: month = "February"; break;
            case 3: month = "March"; break;
            case 4: month = "April"; break;
            case 5: month = "May"; break;
            case 6: month = "June"; break;
            case 7: month = "July"; break;
            case 8: month = "August"; break;
            case 9: month = "September"; break;
            case 10: month = "October"; break;
            case 11: month = "November"; break;
            case 12: month = "December"; break;
            default: break;
        }
        return month;
    }

    public void maximumDay()
    {
        switch (Integer.parseInt(month))
        {
            case 1: maxDay = 31; break;
            case 2: maxDay = 29; break;
            case 3: maxDay = 31; break;
            case 4: maxDay = 30; break;
            case 5: maxDay = 31; break;
            case 6: maxDay = 30; break;
            case 7: maxDay = 31; break;
            case 8: maxDay = 31; break;
            case 9: maxDay = 30; break;
            case 10: maxDay = 31; break;
            case 11: maxDay = 30; break;
            case 12: maxDay = 31; break;
            default: break;
        }
    }
}
