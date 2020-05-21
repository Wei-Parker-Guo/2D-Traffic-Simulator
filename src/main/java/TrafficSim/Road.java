package TrafficSim;

import java.awt.*;
import java.util.Hashtable;
import java.util.Random;

//class representing a two lane road with driver on right
public class Road extends Block {

    public Road(Point direction, Point location, int speed_limit) {
        super(direction, location, speed_limit);
    }
}
