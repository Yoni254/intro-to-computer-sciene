/*
 * 
 *
 * the program will recive a 2 numbers. 
 * one will be the hours the other minutes
 * the number will show the time
 * */
 import java.util.Scanner;
public class mesima27
{
    public static void main(String[]args)
    {
        
        Scanner scan=new Scanner(System.in);
        int hour, minute, format;
        String printEndText = "", timeString = ""
        System.out.println("please state the hour");
        hour= scan.nextInt();
        System.out.println("please state the minute");
        minute= scan.nextInt();
        if(hour<0 || hour>23 || minute<0 || minute>59) {
            System.out.println("are you searious!!?!? \nwhat was so complacated dumass");
            return;
        }
        System.out.println("would you like the time to be shown in a 12 or 24 hour format?");
        format= scan.nextInt();
        
        if( format!=12 && format!=24)
        {
            System.out.println("are you searious!!?!?");
            System.out.println("what was so complacated dumass");
            
        }

        // Handle formats
        if (format == 12) {
            printEndText = "AM";
            if (hour > 12) {
                hour -= 12;
                printEndText = "PM";
            }
        }

        //timeString += (hour > 10)? "0" + (String)hour : (String)hour;
        timeString +=  ":";
        //timeString += (minute > 10)? "0" + (String)minute : (String)minute;

        System.out.println(timeString);

        
        }
        
        
    
    }
