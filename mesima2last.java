/*
 * this program will caculate daily paycheck of worker
 *
 * 
 * 
 * */
 import java.util.Scanner;
 public class mesima2last
 {
     public static void main(String[]args)
     {
         Scanner scan=new Scanner(System.in);
         final int flat_fee;
         final int hours;
         final int day;
         System.out.println("please insert flat fee for an hours work.");
         flat_fee= scan.nextInt();
         System.out.println("please insert the amount of hours you worked today");
         hours= scan.nextInt();
         System.out.println("please insert the day you worked (sunday=1,monday=2 and so on)");
         day=scan.nextInt();
          double paycheck; 
          int newhours;
         
         switch (day)
         {
             case 1: 
             case 2:
             case 3:
             case 4:
             case 5:
             
             if (hours>=8)
             {
                newhours= hours-8;
                paycheck=(8*flat_fee)+newhours*flat_fee*1.25;
                System.out.println("your paycheck is...");
                  System.out.println(+paycheck);
                
                
                 
                }
                else 
                {
                  paycheck=hours*flat_fee; 
                  System.out.println("your paycheck is...");
                  System.out.println(+paycheck);
                }
             break;
             
             case 6: 
             if(hours>=6)
             {
                 newhours= hours-6;
                paycheck=(6*flat_fee)+newhours*flat_fee*1.50;
                System.out.println("your paycheck is...");
                  System.out.println(+paycheck);
                }
                else 
                {
                  paycheck=hours*flat_fee;
                  System.out.println("your paycheck is...");
                  System.out.println(+paycheck);
                }
             
             break;
             
             case 7: 
             if(hours>=4)
             {
                 newhours= hours-4;
                paycheck=(4*flat_fee)+newhours*flat_fee*2.0;
                System.out.println("your paycheck is...");
                  System.out.println(+paycheck);
                }
                else 
                {
                  paycheck=hours*flat_fee; 
                  System.out.println("your paycheck is...");
                  System.out.println(+paycheck);
                }
             
             break;
            }
            
        
        }
    }