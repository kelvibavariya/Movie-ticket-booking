
package p1;

import java.io.FileWriter;
import java.io.IOException;
public class online_portal extends Movie{
   //create file of name-"Movie Ticket.txt" ; which will act as a conformation slip of the booking
    public void display(String n,int g,int v,int t)
    {
        try {  
        FileWriter fwrite = new FileWriter("D:Movie Ticket.txt");
        fwrite.write("*******************************\n");
        fwrite.write("Name of the Movie: "+n+"\n");
        fwrite.write("Total no of general seat: "+g+"\n");
        fwrite.write("Total no of VIP seat: "+v+"\n");
        fwrite.write("Your Total Payment: "+t+"\n");
        fwrite.write("~~~~~~~ENJOY YOUR MOVIE~~~~~~~\n");
        fwrite.write("*******************************");
        fwrite.close();   
    } catch (IOException e) {  
        System.out.println("Unexpected error occurred");  
        e.printStackTrace();  
        }  
    }
    
   //update general category seat after booking by the user
    public int update_general(int old,int g)
    {
        int New=old-g;
        return New;
    }
    //update VIP category seat after booking by the user
    public int update_VIP(int old,int v)
    {
        int New=old-v;
        return New;
    }
}

