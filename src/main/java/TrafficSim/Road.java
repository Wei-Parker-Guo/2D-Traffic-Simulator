package TrafficSim;

import java.util.ArrayList;

//class representing a two lane road with driver on right
public class Road {

    //attributes defaulted to a right pointing road of length 6
    public String id;
    private int length = 6;
    public int[] start = {6,1};
    public int[] end = {0,1};
    public int[] direction = {0,1};
    private int speed_limit = 3;
    private ArrayList<Intersection> intersections;

    //methods
    public void spawn_car(){

    }

    public String printStartLoc(){
        return String.format("x: %d y: %d", start[0], start[1]);
    }

    public String printEndLoc(){
        return String.format("x: %d y: %d", end[0], end[1]);
    }

    public String printInfo(){
        return "42";
    }
}
