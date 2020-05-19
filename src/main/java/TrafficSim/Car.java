package TrafficSim;

import java.util.Arrays;

// class representing a simulated car
public class Car {

    //class constants
    final static int CAR_LENGTH = 2;
    final static int CAR_SPEED = 1;
    final static int CAR_ACC = 1;

    //attributes
    public int[] position;
    public String id;
    public int length = CAR_LENGTH; //default length is 2
    public int width = CAR_LENGTH/2;
    private int speed = CAR_SPEED;
    private int acceleration = CAR_ACC;
    private Object currentTerrain;

    //constructors
    public Car(int id){
        this.id = "Car" + id;
    }

    public Car(int id, int length){
        this.id = "Car" + id;
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
