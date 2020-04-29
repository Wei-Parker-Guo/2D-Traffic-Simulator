package TrafficSim;

public class Bus extends Car {
    //constructor
    public Bus(int id, int length) {
        super(id, length);
        this.id = "Bus" + id;
        this.length *= 3;
    }
}
