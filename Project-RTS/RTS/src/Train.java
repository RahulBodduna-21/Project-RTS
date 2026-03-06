public class Train {

    int id;
    String name;
    String source;
    String destination;
    String time;
    String date;
    int distance;   // km (for price calculation)

    public Train(int id,String name,String source,String destination,
                 String time,String date,int distance){

        this.id=id;
        this.name=name;
        this.source=source;
        this.destination=destination;
        this.time=time;
        this.date=date;
        this.distance=distance;
    }

    public void display(){
        System.out.println(id+" | "+name+
                " | "+source+" -> "+destination+
                " | "+time+
                " | "+date+
                " | "+distance+"km");
    }
}
