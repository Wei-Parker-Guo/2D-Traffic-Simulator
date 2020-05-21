package TrafficSim;

import GUI.Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    //attributes
    public boolean verbose = false;
    private int update_rate = 20; //times per second, default to 30 cycle per second
    private boolean paused = false;
    private boolean stopped = false;
    private ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
    private Menu menu;

    //city attributes
    public Hashtable<Point, Block> map = new Hashtable<>(); //map of the road structure
    public Hashtable<Point, Road> road_map = new Hashtable<>(); //map of road used to spawn cars
    public ArrayList<Car> cars = new ArrayList<>(); //list of available cars
    public int generate_cycles = 1;

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
            //run simulation math
            if(menu.sim_panel.status.equals("play")) {
                if(generate_cycles!=0) {
                    //refresh maps
                    map = menu.sim_panel.map;
                    road_map = menu.sim_panel.road_map;

                    //iterate to spawn cars and move cars
                    for (Point pos : road_map.keySet()) {
                        Car new_car = spawn_car(map, pos, 10);
                        if (new_car != null) cars.add(new_car);
                    }
                    if(generate_cycles==1) menu.sim_panel.canvas.cars = cars;
                    generate_cycles-=1;
                }
                for (Car car : cars) {
                    car.move();
                }
            }
            if(menu.sim_panel.status.equals("stop")){
                generate_cycles = 1;
                menu.sim_panel.canvas.cars.clear();
            }

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

    //methods to spawn a car with a random chance given by parameter
    public Car spawn_car(Hashtable<Point, Block> map, Point pos, int chance){
        Car new_car = null;
        Random rand = new Random();
        int dice = rand.nextInt(chance);
        if(dice == chance/2) new_car = new Car(pos, map);
        return new_car;
    }
}
