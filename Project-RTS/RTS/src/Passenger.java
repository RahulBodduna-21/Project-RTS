import java.util.Scanner;

public class Passenger {

    String name;
    String phone;
    String aadhar;

    public void input(){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Name: ");
        name=sc.nextLine();

        // PHONE VALIDATION
        while(true){
            System.out.print("Phone (10 digits): ");
            phone=sc.nextLine();
            if(phone.matches("\\d{10}"))
                break;
            System.out.println("❌ Invalid phone number!");
        }

        // AADHAR VALIDATION
        while(true){
            System.out.print("Aadhar (12 digits): ");
            aadhar=sc.nextLine();
            if(aadhar.matches("\\d{12}"))
                break;
            System.out.println("❌ Invalid Aadhar!");
        }
    }
}
