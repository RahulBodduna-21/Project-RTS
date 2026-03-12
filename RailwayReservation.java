// ============================================================
// RAILWAY PASSENGER TICKET RESERVATION SYSTEM
// DSA BASED JAVA CONSOLE APPLICATION
// ============================================================

import java.util.*;

// ============================================================
// TRAIN CLASS (DATA STRUCTURE OBJECT)
// ============================================================

class Train {

    String name, source, dest, depart, arrive;
    HashMap<String,Integer> classes;

    Train(String n,String s,String d,String dep,String arr,
          int sleeper,int s2,int ac){

        name=n;
        source=s;
        dest=d;
        depart=dep;
        arrive=arr;

        // CO1 – HASHMAP DATA STRUCTURE
        classes=new HashMap<>();
        classes.put("Sleeper",sleeper);
        classes.put("2S",s2);
        classes.put("AC",ac);
    }
}

// ============================================================
// MAIN CLASS
// ============================================================

public class RailwayReservation {

    static Scanner sc=new Scanner(System.in);

    // ============================================================
    // CO1 – ARRAYLIST DATA STRUCTURE
    // ============================================================

    static ArrayList<Train> trains=new ArrayList<>();


    // ============================================================
    // INITIAL TRAIN DATABASE
    // ============================================================

    static void loadTrains(){

        trains.add(new Train("Godavari Express","Hyderabad","Vizag","06:00","14:00",350,180,900));
        trains.add(new Train("Charminar Express","Hyderabad","Chennai","08:00","17:00",400,200,950));
        trains.add(new Train("Simhapuri Express","Nellore","Hyderabad","09:00","19:00",370,190,880));
        trains.add(new Train("East Coast Express","Vizag","Chennai","05:30","12:30",330,170,850));
        trains.add(new Train("Janmabhoomi Express","Vizag","Vijayawada","07:00","11:00",220,120,500));
        trains.add(new Train("Krishna Express","Hyderabad","Vijayawada","06:30","12:00",300,150,700));

        // Added more trains
        trains.add(new Train("Duronto Express","Hyderabad","Delhi","21:00","08:00",800,450,2000));
        trains.add(new Train("Garib Rath","Chennai","Hyderabad","18:00","06:00",500,250,1200));
        trains.add(new Train("Shatabdi Express","Vijayawada","Chennai","06:00","10:00",600,300,1500));
        trains.add(new Train("Rajdhani Express","Delhi","Chennai","16:00","06:00",900,500,2500));
        trains.add(new Train("Intercity Express","Vizag","Hyderabad","13:00","22:00",320,160,750));
        trains.add(new Train("Falaknuma Express","Secunderabad","Bangalore","15:00","05:00",450,220,1000));
    }


    // ============================================================
    // CO5 – SMART CROWD PREDICTION ALGORITHM
    // ============================================================

    static String predictCrowd(Train t){

        String time=t.depart.trim();

        // Extract hour safely
        int hour=Integer.parseInt(time.substring(0,2));

        if((hour>=6 && hour<=10) || (hour>=17 && hour<=21))
            return "🔴 High Crowd";
        else if(hour>=11 && hour<=16)
            return "🟡 Medium Crowd";
        else
            return "🟢 Low Crowd";
    }


    // ============================================================
    // CO5 – UNIQUE PNR GENERATION ALGORITHM
    // ============================================================

    static String generatePNR(){

        String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r=new Random();

        StringBuilder pnr=new StringBuilder();

        for(int i=0;i<10;i++){
            int index=r.nextInt(chars.length());
            pnr.append(chars.charAt(index));
        }

        return pnr.toString();
    }


    // ============================================================
    // CO3 – QUEUE STYLE VALIDATION
    // ============================================================

    static boolean validate(String phone,String aadhaar,String gender){

        if(!phone.matches("\\d{10}")){
            System.out.println("❌ Phone must be 10 digits");
            return false;
        }

        if(!aadhaar.matches("\\d{12}")){
            System.out.println("❌ Aadhaar must be 12 digits");
            return false;
        }

        if(gender.isEmpty()){
            System.out.println("❌ Select gender");
            return false;
        }

        return true;
    }


    // ============================================================
    // CO2 – LINEAR SEARCH ALGORITHM
    // ============================================================

    static ArrayList<Train> search(String source,String dest){

        ArrayList<Train> result=new ArrayList<>();

        for(Train t:trains){
            if(t.source.equalsIgnoreCase(source)
            && t.dest.equalsIgnoreCase(dest)){
                result.add(t);
            }
        }

        return result;
    }


    // ============================================================
    // DISPLAY TRAINS
    // ============================================================

    static void display(ArrayList<Train> list){

        if(list.isEmpty()){
            System.out.println("No trains found.");
            return;
        }

        int i=1;

        for(Train t:list){

            System.out.println("\n"+i+". "+t.name);
            System.out.println("   "+t.source+" ➜ "+t.dest);
            System.out.println("   Time: "+t.depart+" - "+t.arrive);

            // Crowd Prediction
            System.out.println("   Crowd Level: "+predictCrowd(t));

            i++;
        }
    }


    // ============================================================
    // BOOKING SYSTEM
    // ============================================================

    static void bookTicket(Train train,
                           String name,
                           String phone,
                           String aadhaar,
                           String gender){

        System.out.println("\nSelect Class:");
        System.out.println("1. Sleeper");
        System.out.println("2. 2S");
        System.out.println("3. AC");

        int ch=sc.nextInt();

        String cls="";
        if(ch==1) cls="Sleeper";
        else if(ch==2) cls="2S";
        else cls="AC";

        System.out.print("Number of seats: ");
        int seats=sc.nextInt();

        int price=train.classes.get(cls);
        int total=price*seats;

        String pnr=generatePNR();

        // ========================================================
        // FINAL TICKET OUTPUT
        // ========================================================

        System.out.println("\n========== BOOKING CONFIRMED ==========");
        System.out.println("PNR Number: "+pnr);
        System.out.println("Passenger: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Phone: "+phone);
        System.out.println("Aadhaar: "+aadhaar);

        System.out.println("\nTrain: "+train.name);
        System.out.println("Route: "+train.source+" ➜ "+train.dest);
        System.out.println("Time: "+train.depart+" - "+train.arrive);
        System.out.println("Class: "+cls);
        System.out.println("Seats: "+seats);
        System.out.println("Total Paid: ₹"+total);
        System.out.println("=======================================");
    }


    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args){

        loadTrains();

        System.out.println("🚆 Railway Ticket Reservation System");

        System.out.print("Enter Name: ");
        String name=sc.nextLine();

        System.out.print("Phone: ");
        String phone=sc.nextLine();

        System.out.print("Aadhaar: ");
        String aadhaar=sc.nextLine();

        System.out.print("Gender: ");
        String gender=sc.nextLine();

        if(!validate(phone,aadhaar,gender))
            return;

        System.out.print("Source: ");
        String source=sc.nextLine();

        System.out.print("Destination: ");
        String dest=sc.nextLine();

        ArrayList<Train> results=search(source,dest);

        display(results);

        if(results.isEmpty()) return;

        System.out.print("\nSelect Train Number: ");
        int choice=sc.nextInt();

        Train selected=results.get(choice-1);

        bookTicket(selected,name,phone,aadhaar,gender);
    }
}