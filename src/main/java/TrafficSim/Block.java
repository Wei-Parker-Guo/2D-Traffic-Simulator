package TrafficSim;

import java.awt.*;

//a block represents an abstract concept of a terrain piece, it can have directions and locations
public class Block {
    public Point direction;
    public Point location;
    public int speed_limit = 3;

    Block(Point direction, Point location, int speed_limit){
        this.direction = direction;
        this.location = location;
        this.speed_limit = speed_limit;
    }
}
