import java.util.Scanner;

public class Ticket {

    String seatType;
    double price;

    public void chooseSeat(Train t){

        Scanner sc=new Scanner(System.in);

        System.out.println("\nChoose Seat Type");
        System.out.println("1. Sleeper");
        System.out.println("2. 2S");
        System.out.println("3. AC");

        int ch=sc.nextInt();

        double rate=0;

        switch(ch){

            case 1:
                seatType="Sleeper";
                rate=0.5;
                break;

            case 2:
                seatType="2S";
                rate=0.3;
                break;

            case 3:
                seatType="AC";
                rate=1.2;
                break;

            default:
                System.out.println("Invalid — Default Sleeper");
                seatType="Sleeper";
                rate=0.5;
        }

        price=t.distance * rate;
    }

    public void print(){
        System.out.println("Seat Type : "+seatType);
        System.out.println("Ticket Cost : ₹"+price);
    }
}
