
package p2;
import java.io.File;
import java.io.FileNotFoundException;
import p1.Movie;
import p1.online_portal;
import java.util.Scanner;

//for login password of the manager
interface password
{
    String passWord="Manager#21";
}
// custom Exception-when all seat are reserved
class Housefull extends Exception 
{
    String m;
    Housefull(String m)
    {
        this.m=m;
    }
    public String toString() {
    return "Sorry! no more seat is available for "+m;
    }
}
//Ticket_Booking implements password interface
public class Ticket_Booking implements password {
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int choice,C;
        boolean flag=false,find=false;
        int p=0,q=-1;
        online_portal list[]=new online_portal [100];
        //menu
        do
        {
        System.out.println("1.Manager");
        System.out.println("2.Audience");
        System.out.println("3.exit");
        System.out.print("Enter your preference:");
        int c=sc.nextInt();
            switch(c)
            {
            case 1:    
                       System.out.print("Enter your passWord: ");
                       String check=sc.next();
                       System.out.println(" ");
                       if(!(check.equals(passWord)))
                       {
                           System.out.println("Wrong password\n");
                       }
                        else
                       {   
                           
                            do{
                                System.out.println("1.Add Movie");
                                System.out.println("2.Remove Movie");
                                System.out.println("3.Exit");
                                System.out.print("Enter your Choice:");
                                choice=sc.nextInt();
                                switch(choice){
                        case 1:
                            System.out.print("Enter no of movie:");
                            int n=sc.nextInt();
                            int N=n;
                            N+=p;
                            for(int i=p;i<N;i++)
                            {
                                System.out.println("Enter Movie "+(i+1)+" Information");
                                list[i]=new online_portal();
                                list[i].getInfo();
                            }
                            p+=n;
                            break;
                        case 2:
                            System.out.print("Enter the name of the movie which you want to delete: ");
                            String name = sc.next();
                            for(int i=0;i<p;i++){
                                if(name.equals(list[i].name)){
                                    q = i;
                                }
                            }
                            if(q==-1){
                                System.out.println("Movie does not exist\n");
                                break;
                            }
                            for(int i=q;i<p-1;i++){
                                list[i].name = list[i+1].name;
                                list[i].general_ticket = list[i+1].general_ticket;
                                list[i].VIP_ticket = list[i+1].VIP_ticket;
                                list[i].general_cost = list[i+1].general_cost;
                                list[i].VIP_cost = list[i+1].VIP_cost;
                            }
                            if(p>0){
                                p-=1;
                                System.out.println("Movie Deleted\n");
                            }
                            else{
                                System.out.println("Movie does not exist\n");
                            }
                            break;
                    }
                }while(choice!=3);
                       }
                     break;
                       

            case 2:
                 do
                 {
                     System.out.println("1.View Details");
                     System.out.println("2.Book Ticket");
                     System.out.println("3.Get Ticket");
                     System.out.println("4.exit");
                     System.out.print("Enter your Choice:");
                     choice=sc.nextInt();
                     switch(choice)
                     {
                         case 1:
                          for(int j=0;j<p;j++)
                         {
                            list[j].view(); 
                            System.out.println(" ");
                         }
                          break;
                         case 2: online_portal o=new online_portal();
                             int g,gc,vc,v,t;
                         System.out.print("Enter name of the movie:");
                         String s=sc.next();
                         
                         
                         for(int i=0;i<p;i++)
                         {
                             if(list[i].name.equals(s))
                             {
                                System.out.print("Enter no of general tickets:");
                                g=sc.nextInt();
                                System.out.print("Enter no of VIP tickets:");
                                v=sc.nextInt();
                                 gc=list[i].general_cost*g;
                                 vc=list[i].VIP_cost*v;
                                 int ug=o.update_general(list[i].general_ticket,g);
                                 int uv=o.update_VIP(list[i].VIP_ticket,v);
                                 find=true;
                                 //throw exception
                                 try{
                                     if(ug<0 || uv<0)
                                     {
                                         flag=true;
                                         throw new Housefull(list[i].name);
                                     }
                                     else
                                     {
                                        list[i].general_ticket=ug;
                                        list[i].VIP_ticket=uv;
                                        flag=false;
                                     }
                                 }catch(Housefull h)
                                 {
                                     System.out.println(h+"\n");
                                 }
                                 
                                 t=gc+vc;
                                 if(!flag) //if seat is available then only ticket will be created
                                 o.display(s, g, v, t);
                             }
                             else
                             {
                                 find=false;
                             }
                         }
                         if(!find)
                         {
                             System.out.println("Movie is not available");
                         }
                         break;
                         case 3:
                             if(flag)
                             {
                                 System.out.println("\nTicket Booking failed\n");
                             }
                             //if ticket generated then only it will be display
                             else{
                                 try {  
                                File f1 = new File("D:Movie Ticket.txt");    
                                Scanner read = new Scanner(f1);  
                                while (read.hasNextLine()) {  
                                    String data = read.nextLine();  
                                    System.out.println(data);  
                                }  
                                read.close();  
                            } catch (FileNotFoundException exception) {  
                                System.out.println("Unexcpected error occurred!");  
                                exception.printStackTrace();  
                            }  
                             }
                         break;
                                    
                         }
                     }while(choice!=4);
                break;
            default:System.out.println("Invalid choice");
            case 3:return;
            }
        }while(true);
    }
}
