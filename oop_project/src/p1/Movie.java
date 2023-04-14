
package p1;


import java.util.Scanner;


public class Movie {
    public String name;
    public int general_ticket;
    public int VIP_ticket;
    public int general_cost;
    public int VIP_cost;
    //take all information related to movie from Manager
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the Movie:");
        name=sc.next();
        System.out.print("Enter no of ticket available for general category:");
        general_ticket=sc.nextInt();
        System.out.print("Enter no of ticket available for VIP category:");
        VIP_ticket=sc.nextInt();
        System.out.print("Enter cost of general category ticket:");
        general_cost=sc.nextInt();
        System.out.print("Enter cost of VIP category ticket:");
        VIP_cost=sc.nextInt();
    }
    //display all details of the movie
    public void view()
    {
        System.out.println("Name of the Movie:"+name);
        System.out.println("Total no of general seat:"+general_ticket);
        System.out.println("Total no of VIP seat:"+VIP_ticket);
        System.out.println("cost of general ticket:"+general_cost);
        System.out.println("cost of VIP ticket:"+VIP_cost);
    }
    
}
