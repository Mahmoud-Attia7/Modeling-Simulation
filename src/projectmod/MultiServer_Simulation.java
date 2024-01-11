
package projectmod;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MultiServer_Simulation {
     public static Customer[] customers;
    public static ArrayList<Customer> abelCust = new ArrayList<Customer>();
    public static ArrayList<Customer> bakerCust = new ArrayList<Customer>();
    public static ArrayList<Customer> misseCust = new ArrayList<Customer>();
    private static int Cust_num;

    MultiServer_Simulation(int cust_num)
    {
        abelCust = new ArrayList<Customer>();
        bakerCust = new ArrayList<Customer>();
        misseCust = new ArrayList<Customer>();
        Cust_num = cust_num;

    }
    public static void ComputeArrivalTimes()
    {
        int clock = 0;
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
    public static void Compute_R_ServiceTime_Baker(int i)
    {
                if(customers[i].R_Service_Time >= 1 && customers[i].R_Service_Time <= 35)
                {
                    customers[i].Service_Time = 4;
                }
                else if(customers[i].R_Service_Time >= 36 && customers[i].R_Service_Time <= 60)
                {
                   customers[i].Service_Time = 5;
                }
                else if(customers[i].R_Service_Time >= 61 && customers[i].R_Service_Time <= 80)
                {
                   customers[i].Service_Time = 6;
                }
                else if(customers[i].R_Service_Time >= 81 && customers[i].R_Service_Time <= 100)
                {
                   customers[i].Service_Time = 7;
                }

    }
    
    public static void Compute_R_ServiceTime_Misse(int i)
    {
                if(customers[i].R_Service_Time >= 1 && customers[i].R_Service_Time <= 25)
                {
                    customers[i].Service_Time = 3;
                }
                else if(customers[i].R_Service_Time >= 26 && customers[i].R_Service_Time <= 55)
                {
                   customers[i].Service_Time = 4;
                }
                else if(customers[i].R_Service_Time >= 56 && customers[i].R_Service_Time <= 73)
                {
                   customers[i].Service_Time = 5;
                }
                else if(customers[i].R_Service_Time >= 74 && customers[i].R_Service_Time <= 100)
                {
                   customers[i].Service_Time = 6;
                }

    }
    

    public static void Compute_R_ServiceTime_Abel(int i)
    {

                if(customers[i].R_Service_Time >= 1 && customers[i].R_Service_Time <= 30)
                {
                    customers[i].Service_Time = 2;
                }
                else if(customers[i].R_Service_Time >= 31 && customers[i].R_Service_Time <= 58)
                {
                   customers[i].Service_Time = 3;
                }
                else if(customers[i].R_Service_Time >= 59 && customers[i].R_Service_Time <= 83)
                {
                   customers[i].Service_Time = 4;
                }
                else if(customers[i].R_Service_Time >= 84 && customers[i].R_Service_Time <= 100)
                {
                   customers[i].Service_Time = 5;
                }


    }


    public static Customer[] Simulate()
    {

         customers= new Customer[Cust_num];


         Random random = new Random();

       for(int i=0; i<Cust_num; i++)
      {
          customers[i]=new Customer();
          customers[i].IAT= random.nextInt(1000);
          customers[i].R_Service_Time= random.nextInt(100);
      }

      ComputeArrivalTimes();

       for(int i=0; i<Cust_num; i++)
      {
          if(i==0)
          {
               customers[0].Service_Begin= customers[i].Arrival_Time;
               customers[0].Accounter = 1;
               Compute_R_ServiceTime_Abel(0);
               abelCust.add(customers[0]);
//               customers[0].Server_Idle =customers[i].Arrival_Time;
          }
          else
          {
              if(customers[i].Arrival_Time >= abelCust.get(abelCust.size()-1).Service_End)
              {
                  customers[i].Accounter = 1;
                  Compute_R_ServiceTime_Abel(i);
                  abelCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,abelCust.get(abelCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else if(bakerCust.isEmpty())
              {
                  customers[i].Accounter = 2;
                  Compute_R_ServiceTime_Baker(i);
                  bakerCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,bakerCust.get(bakerCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else if(customers[i].Arrival_Time >= bakerCust.get(bakerCust.size()-1).Service_End)
              {
                  customers[i].Accounter = 2;
                  Compute_R_ServiceTime_Baker(i);
                  bakerCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,bakerCust.get(bakerCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else if(misseCust.isEmpty())
              {
                  customers[i].Accounter = 3;
                  Compute_R_ServiceTime_Misse(i);
                  misseCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,misseCust.get(misseCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else if(customers[i].Arrival_Time >= misseCust.get(misseCust.size()-1).Service_End)
              {
                  customers[i].Accounter = 3;
                  Compute_R_ServiceTime_Misse(i);
                  misseCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,misseCust.get(misseCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else if(abelCust.get(abelCust.size()-1).Service_End <= bakerCust.get(bakerCust.size()-1).Service_End)
              {
                  customers[i].Accounter = 1;
                  Compute_R_ServiceTime_Abel(i);
                  abelCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,abelCust.get(abelCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else if(bakerCust.get(bakerCust.size()-1).Service_End <= misseCust.get(misseCust.size()-1).Service_End)
              {
                  customers[i].Accounter = 2;
                  Compute_R_ServiceTime_Baker(i);
                  bakerCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,bakerCust.get(bakerCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
              else
              {
                  customers[0].Accounter = 3;
                  Compute_R_ServiceTime_Misse(i);
                  misseCust.add(customers[i]);
                  customers[i].Service_Begin=Math.max(customers[i].Arrival_Time,misseCust.get(misseCust.size()-1).Service_End);
                  customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
              }
          }

          customers[i].Service_End= customers[i].Service_Begin + customers[i].Service_Time;
           customers[i].Waiting_Time= customers[i].Service_Begin- customers[i].Arrival_Time;
           customers[i].Time_Spent = customers[i].Waiting_Time+ customers[i].Service_Time;
//           if(customers[i].Accounter == "Able")
//           {
//                customers[i].Server_Idle = customers[i].Service_Begin- abelCust.get(abelCust.size()-1).Service_End;
//           }
//           else
//           {
//               customers[i].Server_Idle = customers[i].Service_Begin - bakerCust.get(bakerCust.size()-1).Service_End;
//           }
//
      }
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


    public static void main(String[] args) {

         //read simulation length from the user
      Scanner sc= new Scanner(System.in);
      System.out.print("Enter Customers Count \n");
      Cust_num= sc.nextInt();
      Simulate();

//      Print_Simulation_Table();
      Compute_Statestics();


    }
}
