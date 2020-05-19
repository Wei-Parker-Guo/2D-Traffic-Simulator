package TrafficSim;

import GUI.Menu;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    //attributes
    public boolean verbose = false;
    private int update_rate = 30; //times per second, default to 30 cycle per second
    private boolean paused = false;
    private boolean stopped = false;
    private ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
    private Menu menu;

    //city attributes
    private ArrayList<Road> roads;
    private ArrayList<Intersection> intersections;
    private ArrayList<TrafficLight> traffic_lights;
    private ArrayList<Car> cars;
    private ArrayList<Bus> buses;
    private ArrayList<Motorbike> motor_bikes;

    //entry point
    public static void main(String[] args) {
        Main sim = new Main();
        if (args[0].equals("verbose")) sim.verbose = true;
        sim.initiate();
    }

    //initiation
    public void initiate(){
        menu = new Menu();
        menu.construct();
        change_update_rate_and_run(update_rate);
    }

    //update loop
    public void update(){
        if (paused){
            return;
        }
        //start cycle verbose
        if (verbose){
            System.out.println("Update Cycle Started");
        }

        //edit mode
        if(menu.mode==0) {
            menu.edit_panel.canvas.repaint();
        }

        //sim mode
        else if(menu.mode==1){
            menu.sim_panel.canvas.repaint();
        }

        //end cycle verbose
        if (verbose){
            System.out.println("Update Cycle Ended");
        }
    }

    //method to change update cycle rate
    public void change_update_rate_and_run(int rate){
        update_rate = rate;
        //set up a scheduler to determine update frequency
        e.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                update();
            }
        },0, 1000/update_rate, TimeUnit.MILLISECONDS);
    }

    //pause toggle
    public void toggle_pause(){
        paused = !paused;
    }

    //stop
    public void stop(){
        stopped = true;
        e.shutdown();
    }
}