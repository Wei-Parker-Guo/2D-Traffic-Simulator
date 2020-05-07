package TrafficSim;

//class representing a traffic light
public class TrafficLight {
    private String state = "red";
    private String[] states = {"red", "yellow", "green"};
    private int counter = 0;
    private int wait_interval = 5;

    public void operate(){
        counter = (counter + 1) % (wait_interval * 2 + 3);

        int state_index = 0;
        if(counter <= wait_interval + 2 && counter >= wait_interval) state_index = 1;
        if(counter > wait_interval + 2) state_index = 2;
        state = states[state_index];
    }
}
