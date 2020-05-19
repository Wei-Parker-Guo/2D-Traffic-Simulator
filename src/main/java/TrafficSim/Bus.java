package TrafficSim;

import java.util.Arrays;

public class Bus extends Car {
    //constructor
    public Bus(int id){
        super(id);
        this.id = "Bus" + id;
        this.length = Car.CAR_LENGTH * 3;
    }

    public Bus(int id, int length) {
        super(id, length);
        this.id = "Bus" + id;
        this.length *= 3;
    }

    //to string
    @Override
    public String toString() {
        String result = super.toString();
        return result.replace("Car", "Bus");
    }
}
