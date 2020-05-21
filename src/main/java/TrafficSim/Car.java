package TrafficSim;

import java.awt.*;
import java.util.Arrays;
import java.util.Hashtable;

// class representing a simulated car
public class Car {

    //class constants, must be integers to work with the unit vector based simulator
    final static int CAR_LENGTH = 2;
    final static int CAR_SPEED = 1;
    final static int CAR_ACC = 1;

    //attributes
    public Point position;
    public String id;
    public int length = CAR_LENGTH; //default length is 2
    public int width = CAR_LENGTH/2;
    private int speed = CAR_SPEED;
    private final int acceleration = CAR_ACC;
    private Block currentTerrain;
    public Hashtable<Point, Block> map = new Hashtable<>(); //each car generated remembers the total terrain for moving

    //constructors
    public Car(int id){
        this.id = "Car" + id;
    }

    public Car(int id, int length){
        this.id = "Car" + id;
        this.length = length;
        this.width = this.length/2;
    }

    public Car(Point pos, Hashtable<Point, Block> map){
        this.id = "Car" + pos.x + pos.y;
        this.position = pos;
        this.map = map;
    }

    //to string
    @Override
    public String toString() {
        return "Car{" +
                "position=" + position.toString() +
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
        //figure out which terrain piece its on
        currentTerrain = map.get(position);

        if(currentTerrain!=null){
        //move
        speed += acceleration;
        if(currentTerrain.speed_limit<speed) speed = currentTerrain.speed_limit; //apply speed limit
        //apply vector based rotation and interpolation
        position.x += (currentTerrain.direction.x * speed * 20);
        position.y += (currentTerrain.direction.y * speed * 20);
        }
    }

    //method to report a car's info
    public String printCarStatus(){
        return this.toString();
    }
}
