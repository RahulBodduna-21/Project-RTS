import java.util.Scanner;
import java.util.List;


public class Main {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        Passenger p=new Passenger();
        p.input();

        System.out.print("Source: ");
        String src=sc.nextLine();

        System.out.print("Destination: ");
        String dest=sc.nextLine();

        RailwaySystem rs=new RailwaySystem();

        List<Train> list = rs.search(src,dest);


        if(list.size()==0){
            System.out.println("❌ No trains found");
            return;
        }

        System.out.println("\nAvailable Trains:");
        for(Train t:list)
            t.display();

        System.out.print("\nSelect Train ID: ");
        int id=sc.nextInt();

        for(Train t:list){

            if(t.id==id){

                Ticket ticket=new Ticket();
                ticket.chooseSeat(t);

                System.out.println("\n✅ BOOKED SUCCESSFULLY");
                System.out.println("Passenger: "+p.name);
                t.display();
                ticket.print();
                return;
            }
        }

        System.out.println("Invalid Train Selection");
    }
}
