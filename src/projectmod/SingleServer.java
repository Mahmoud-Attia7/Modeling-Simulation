
package projectmod;

import java.util.Random;
import java.util.Scanner;


public class SingleServer {
    private static int IATrange;
    private static int Cust_num;
    private static int RS_range;
    public static Customer[] customers;
    
    SingleServer(int IATr, int cust_num, int rs_range) {
        IATrange = IATr;
        Cust_num = cust_num;
        RS_range = rs_range;
     }

    
    public static void ComputeArrivalTimes()
    {
        int clock = 0;
        int Time_Between_Ariavals = 0;
        for(int i=0; i<Cust_num; i++)
        {
                if(customers[i].IAT >= 1 && customers[i].IAT <= 125)
                {
                    customers[i].Arrival_Time= clock + 1;
                    clock += 1;
                }
                else if(customers[i].IAT >= 126 && customers[i].IAT <= 250)
                {
                    customers[i].Arrival_Time= clock + 2;
                    clock += 2;
                }
                else if(customers[i].IAT >= 251 && customers[i].IAT <= 375)
                {
                    customers[i].Arrival_Time= clock + 3;
                    clock += 3;
                }
                else if(customers[i].IAT >= 376 && customers[i].IAT <= 500)
                {
                    customers[i].Arrival_Time= clock + 4;
                    clock += 4;
                }
                else if(customers[i].IAT >= 501 && customers[i].IAT <= 625)
                {
                    customers[i].Arrival_Time= clock + 5;
                    clock += 5;
                }
                else if(customers[i].IAT >= 626 && customers[i].IAT <= 750)
                {
                    customers[i].Arrival_Time= clock + 6;
                    clock += 6;
                }
                else if(customers[i].IAT >= 751 && customers[i].IAT <= 875)
                {
                    customers[i].Arrival_Time= clock + 7;
                    clock += 7;
                }
                else if(customers[i].IAT >=  876 && customers[i].IAT <= 1000)
                {
                    customers[i].Arrival_Time= clock + 8;
                    clock += 8;
                }
            
        }
    }
    public static void Compute_R_ServiceTime()
    {
        for(int i=0; i<Cust_num; i++)
        {
                if(customers[i].R_Service_Time >= 1 && customers[i].R_Service_Time <= 10)
                {
                    customers[i].Service_Time = 1;
                }
                else if(customers[i].R_Service_Time >= 11 && customers[i].R_Service_Time <= 30)
                {
                   customers[i].Service_Time = 2;
                }
                else if(customers[i].R_Service_Time >= 31 && customers[i].R_Service_Time <= 60)
                {
                   customers[i].Service_Time = 3;
                }
                else if(customers[i].R_Service_Time >= 61 && customers[i].R_Service_Time <= 85)
                {
                   customers[i].Service_Time = 4;
                }
                else if(customers[i].R_Service_Time >= 86 && customers[i].R_Service_Time <= 95)
                {
                   customers[i].Service_Time = 5;
                }
                else if(customers[i].R_Service_Time >= 96 && customers[i].R_Service_Time <= 100)
                {
                   customers[i].Service_Time = 6;
                }
            
        }
    }
 
    
    public Customer[] Simulate()
    {

         customers= new Customer[Cust_num];
          
         Random random = new Random();
         
       for(int i=0; i<Cust_num; i++)
      {
          customers[i]=new Customer();
          customers[i].IAT= random.nextInt(IATrange);
          customers[i].R_Service_Time= random.nextInt(RS_range);
      }
      
      ComputeArrivalTimes();
      Compute_R_ServiceTime();
      
       for(int i=0; i<Cust_num; i++)
      {
          if(i==0)
          {
               customers[i].Service_Begin= customers[i].Arrival_Time;
          }
          else
          {
              customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,customers[i-1].Service_End);
          }
          
          customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
           customers[i].Waiting_Time= customers[i].Service_Begin- customers[i].Arrival_Time;
           customers[i].Time_Spent = customers[i].Waiting_Time+ customers[i].Service_Time;
           if(i==0)
          {
              customers[i].Server_Idle =customers[i].Arrival_Time;
          }
          else
          {
                 customers[i].Server_Idle = customers[i].Service_Begin- customers[i-1].Service_End;
          }
    
      }
      Print_Simulation_Table();
       return customers;
    }
    
    public static void Compute_Statestics()
    {
            float avgWT = 0;
            float avgST = 0;
            float wt = 0;
            float st = 0;
            for(int i=0; i<Cust_num; i++)
            {
                wt += customers[i].Waiting_Time;
                st += customers[i].Service_Time;
            }
            avgWT = wt/Cust_num;
            avgST = st/Cust_num;
         System.out.println("The Avg waiting time: " + avgWT +" The Avg service time: " + avgST);
         
    }
    public static void Print_Simulation_Table()
    {
         System.out.print("Cust_ID "+   
           "IAT " 
        
          +"Ar "
          +"RST "
          +"ST "  
          +"SBegin "  
          +"SEnd " 
          +"WT " 
          +"TS " + '\n' ) ;   
           
        for(int i=0; i<Cust_num; i++)
      {   
         System.out.print("Cust"+ (i+1)+"   " +   
           customers[i].IAT +"   " + 
           customers[i].Arrival_Time +"   " +  
           customers[i].R_Service_Time+"   "+
           customers[i].Service_Time +"   " +   
           customers[i].Service_Begin +"   " +  
           customers[i].Service_End +"   " +   
           customers[i].Waiting_Time +"   " + 
           customers[i].Time_Spent +"   " + '\n' ) ; 
    }
    }

    public static void main(String[] args) {
       //read simulation length from the user
    
   
      Compute_Statestics();
    }
    
}
