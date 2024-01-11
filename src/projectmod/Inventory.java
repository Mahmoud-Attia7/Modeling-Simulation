package projectmod;

import java.util.Random;
import java.util.Scanner;


public class Inventory {
     public  int cost; //input
    public  int sell; //input

   public  int days; //input
    public  int numOfProduct; //input
    public  int scrap_cost; //input

    public  int total_profit;
    public  Product [] product;

    public Inventory() {
    }

    public Inventory(int cost, int days, int numOfProduct) {
        this.cost = cost;
       
        this.days = days;
        this.numOfProduct = numOfProduct;
       
    }
    

    private  void RandomType() {
        for(int i = 0; i < days; i++)
        {
            if(product[i].R_type >= 1 && product[i].R_type <= 35)
            {
                product[i].type = "Good";
            }
            else if(product[i].R_type >= 36 && product[i].R_type <= 80)
            {
                product[i].type = "Fair";
            }
            else if(product[i].R_type >= 81 && product[i].R_type <= 100)
            {
                product[i].type = "Poor";
            }
            
        }
            
    }

    private  void RandomDemand() {
        for(int i = 0; i < days; i++)
        {
            if(((product[i].type == "Good" )&& (product[i].R_demand >=1) && (product[i].R_demand <= 3))||((product[i].type == "Fair") && (product[i].R_demand >=1)) && ((product[i].R_demand <= 10))||((product[i].type == "Poor" )&& (product[i].R_demand >=1) && (product[i].R_demand <= 44)))
            {
                product[i].Demand = 40;
            }
            else if(((product[i].type == "Good") && (product[i].R_demand >=4 )&& (product[i].R_demand <= 8))||((product[i].type == "Fair" )&& (product[i].R_demand >=11 ))&& ((product[i].R_demand <= 28))||((product[i].type == "Poor") && (product[i].R_demand >=45 && product[i].R_demand <= 66)))
            {
                product[i].Demand = 50;
            }
            else if(((product[i].type == "Good" )&& (product[i].R_demand >=9) && (product[i].R_demand <= 23))||((product[i].type == "Fair") && (product[i].R_demand >=29 )&& (product[i].R_demand <= 68))||((product[i].type == "Poor") && (product[i].R_demand >=67 )&& (product[i].R_demand <= 82)))
            {
                product[i].Demand = 60;
            }
            else if(((product[i].type == "Good") && (product[i].R_demand >=24) && (product[i].R_demand <= 43))||((product[i].type == "Fair") && (product[i].R_demand >=69) && (product[i].R_demand <= 88))||((product[i].type == "Poor") && (product[i].R_demand >=83 )&& (product[i].R_demand <= 94)))
            {
                product[i].Demand = 70;
            }
            else if(((product[i].type == "Good" )&& (product[i].R_demand >=44) && (product[i].R_demand <= 78))||((product[i].type == "Fair") && (product[i].R_demand>=89) && (product[i].R_demand <= 96))||((product[i].type == "Poor" )&& (product[i].R_demand >=95) && (product[i].R_demand <= 100)))
            {
                product[i].Demand = 80;
            }
            else if(((product[i].type == "Good") && (product[i].R_demand >=79) && (product[i].R_demand <= 93))||((product[i].type == "Fair") && (product[i].R_demand >=97) && (product[i].R_demand <= 100)))
            {
                product[i].Demand = 90;
            }
            else if((product[i].type == "Good" )&& (product[i].R_demand >=94) && (product[i].R_demand <= 100))
            {
                product[i].Demand = 100;
            }
        }
        
    }
    
    public  Product[]  simulate()
    {
       product = new Product[days];
//        daily_profit = new int[days];
        total_profit = 0;
        Random random = new Random();
        for(int i = 0; i < days; i++)
        {
            product[i] = new Product();
            product[i].R_type = random.nextInt(100);
            product[i].R_demand = random.nextInt(100);
        }
        RandomType();
        RandomDemand();
        for(int i = 0; i < days; i++)
        {
            if(product[i].Demand <= numOfProduct)
            {
                product[i].revenue_for_sale = (product[i].Demand * sell)/100;
                product[i].lost_profit = 0;
                product[i].scrap_cost = ((numOfProduct - product[i].Demand) * scrap_cost)/100;
            }
            else
            {
                product[i].revenue_for_sale = (numOfProduct * sell)/100;
                product[i].scrap_cost = 0;
                product[i].lost_profit = ((product[i].Demand - numOfProduct) * cost)/100;
            }
            product[i].daily_profit= product[i].revenue_for_sale -((numOfProduct*cost)/100)-product[i].lost_profit+product[i].scrap_cost;
            total_profit += product[i].daily_profit;
        }
        
        return product;
    }
    public  void Print_Simulation_Table()
    {
         System.out.print("Day"+   
           "    Random digit for NP " 
          +"    Types of NP "
          +"    Random digit for demand "
          +"    Demand "  
          +"    Revenue "  
          +"    Lost profit " 
          +"    Scarp " 
          +"    Profit"   
          + '\n' ) ;   
           
        for(int i=0; i<days; i++)
      {   
         System.out.print("\nday"+ (i+1)+"          " +   
           product[i].R_type+"                  " + 
           product[i].type +"                  " +  
           product[i].R_demand+"                    "+
           product[i].Demand +"         " +   
           product[i].revenue_for_sale +"               " +  
           product[i].lost_profit +"          " +   
           product[i].scrap_cost +"         " + 
           product[i].daily_profit+"             " +'\n' ) ; 
    }
        
    }
    public static void main(String[] args) {
   Inventory NP = new Inventory();
//    System.out.print("\nEnter the newspaper cost: ");
//    Scanner in = new Scanner(System.in);
//    NP.cost = in.nextInt();
//    System.out.print("\nEnter how much you sell the newspaper: ");
//    NP.sell = in.nextInt();
//    System.out.print("\nEnter days: ");
//    NP.days = in.nextInt();
//    System.out.print("\nEnter how many newspaper: ");
//    NP.numOfProduct = in.nextInt();
//    System.out.print("\nEnter the newspaper scrap cost: \n");
//    NP.scrap_cost = in.nextInt();
    NP.simulate();
    NP.Print_Simulation_Table();
    }
}
