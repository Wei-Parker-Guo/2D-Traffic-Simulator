package TrafficSim;

import java.awt.*;

//class representing a traffic light
public class TrafficLight extends Block {
    private String state = "red";
    private String[] states = {"red", "yellow", "green"};
    private int counter = 0;
    private int wait_interval = 5;

    TrafficLight(Point direction, Point location, int speed_limit) {
        super(direction, location, speed_limit);
    }

    public void operate(){
        counter = (counter + 1) % (wait_interval * 2 + 3);

        int state_index = 0;
        if(counter <= wait_interval + 2 && counter >= wait_interval) state_index = 1;
        if(counter > wait_interval + 2) state_index = 2;
        state = states[state_index];
    }
}
