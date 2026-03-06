import java.util.*;

public class RailwaySystem {

    ArrayList<Train> trains=new ArrayList<>();

    public RailwaySystem(){

    trains.add(new Train(1,"Charminar Express","Hyderabad","Chennai","06:00","20 Mar",630));
    trains.add(new Train(2,"Godavari Express","Hyderabad","Chennai","09:30","20 Mar",630));
    trains.add(new Train(3,"Krishna Express","Hyderabad","Bangalore","07:45","20 Mar",570));
    trains.add(new Train(4,"Venkatadri","Hyderabad","Delhi","11:00","21 Mar",1670));
    trains.add(new Train(5,"Duronto","Chennai","Hyderabad","05:30","21 Mar",630));
    trains.add(new Train(6,"Shatabdi","Chennai","Bangalore","08:15","20 Mar",350));
    trains.add(new Train(7,"Rajdhani","Delhi","Hyderabad","19:00","20 Mar",1670));
    trains.add(new Train(8,"Garib Rath","Delhi","Chennai","22:10","22 Mar",2180));
    trains.add(new Train(9,"Intercity","Bangalore","Hyderabad","10:20","20 Mar",570));
    trains.add(new Train(10,"Superfast","Hyderabad","Mumbai","06:50","20 Mar",710));
    trains.add(new Train(11,"Express 11","Mumbai","Hyderabad","13:00","20 Mar",710));
    trains.add(new Train(12,"Express 12","Hyderabad","Chennai","14:00","21 Mar",630));
    trains.add(new Train(13,"Express 13","Hyderabad","Chennai","18:00","22 Mar",630));
    trains.add(new Train(14,"Express 14","Bangalore","Chennai","07:00","21 Mar",350));
    trains.add(new Train(15,"Express 15","Chennai","Delhi","16:00","23 Mar",2180));
    trains.add(new Train(16,"Express 16","Hyderabad","Chennai","21:00","24 Mar",630));
    trains.add(new Train(17,"Express 17","Hyderabad","Bangalore","22:00","21 Mar",570));
    trains.add(new Train(18,"Express 18","Delhi","Mumbai","05:00","20 Mar",1400));
    trains.add(new Train(19,"Express 19","Mumbai","Delhi","09:00","20 Mar",1400));
    trains.add(new Train(20,"Express 20","Hyderabad","Chennai","23:15","25 Mar",630));


    }

    public List<Train> search(String src,String dest){

        List<Train> result=new ArrayList<>();

        for(Train t:trains){
            if(t.source.equalsIgnoreCase(src)
            && t.destination.equalsIgnoreCase(dest)){
                result.add(t);
            }
        }

        // SORT BY TRAIN NAME
        Collections.sort(result,(a,b)->a.name.compareTo(b.name));

        return result;
    }
}
