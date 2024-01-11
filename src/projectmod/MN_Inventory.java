package projectmod;

import java.util.Random;
import java.util.Scanner;
import static projectmod.SingleServer.Print_Simulation_Table;

public class MN_Inventory {
    Day[] Days;
    int cycles;
    int days;
    int cond;
    int Quant;
    MN_Inventory(int cycles,int days, int or_condition, int Quantity){
        this.cycles = cycles;
        this.days = days;
    }
    public int ComputeDemand(Day day){
        if (day.rdDemand >= 1 && day.rdDemand <= 33)
            return 0;
        else if (day.rdDemand >= 34 && day.rdDemand <= 58)
            return 1;
        else if (day.rdDemand >= 59 && day.rdDemand <= 78)
            return 2;
        else if (day.rdDemand >= 79 && day.rdDemand <= 90)
            return 3;
        else if (day.rdDemand >= 91 && day.rdDemand <= 100)
            return 4;
        return 0;
    }

    public void ComputeLT(Day day){
        if (day.rdLeadTime >= 1 && day.rdLeadTime <= 30)
            day.leadTime = 1;
        else if (day.rdLeadTime >= 31 && day.rdLeadTime <= 80)
            day.leadTime = 2;
        else if (day.rdLeadTime >= 81 && day.rdLeadTime <= 100)
            day.leadTime = 3;
        }

    public Day[]Simulate(){
        Days = new Day[cycles * days];
        Random random = new Random();
        int cykl = 1;
        for (int x = 0; x<(cycles * days); x++){
            Day day = new Day();
            if(x==0)
            {
                day.invB = 12;
            }
            day.cycle = cykl;
            if(x != 0){
                day.invB = Days[x - 1].invE;
                day.rdDemand = random.nextInt(100);
                day.demand = ComputeDemand(day);
            }
            day.invE = day.invB - day.demand;
            if (day.demand > day.invB)
                day.back_ordering = day.demand - day.invB;
            else
                day.back_ordering = 0;
            if((x % 7) == 0 && x != 0 && day.invB <= cond){
                day.order_quantity = Quant;
                day.invB += day.order_quantity;
                day.rdLeadTime = random.nextInt(100);
                ComputeLT(day);
            }

            if ((x % 7) == 0 && x != 0)
                cykl ++;

            else{
                day.order_quantity = 0;
                day.rdLeadTime = 0;
                day.leadTime = 0;
            }
            Days[x]=day;
        }
        return Days;
    }

    public static void main(String[] args) {
       //read simulation length from the user
      Scanner sc= new Scanner(System.in);
      System.out.print("Enter Customers Count \n");  
   
      Print_Simulation_Table();
//      Compute_Statestics();
    }
}
