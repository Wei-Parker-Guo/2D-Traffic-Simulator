package TrafficSim;

import java.util.Arrays;

// class representing a simulated car
public class Car {

    //attributes
    public int[] position;
    public String id;
    public int length = 2; //default length is 2
    public int width;
    private int speed = 1;
    private int acceleration = 1;
    private Object currentTerrain;

    //constructors
    public Car(int id, int length){
        this.id = "Car" + String.valueOf(id);
        this.length = length;
        this.width = this.length/2;
    }

    //to string
    @Override
    public String toString() {
        return "Car{" +
                "position=" + Arrays.toString(position) +
                ", id='" + id + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", speed=" + speed +
                ", acceleration=" + acceleration +
                ", currentTerrain=" + currentTerrain +
                '}';
    }

    //methods

    //method to move a car
    public void move(){

    }

    //method to turn a car
    private void turn(){

    }

    //method to report a car's info
    public String printCarStatus(){
        return "42";
    }
}
