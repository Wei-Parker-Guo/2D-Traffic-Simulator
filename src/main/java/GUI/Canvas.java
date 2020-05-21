package GUI;

import TrafficSim.Car;
import TrafficSim.Road;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Canvas extends JPanel {

    //attributes
    private Point mouse_loc = new Point(0,0);
    private Point prev_placed_point = new Point(0,0);
    private Point direction = new Point(0,0);
    private boolean placement_ended = false;
    private boolean mouse_inside = false;
    private boolean mouse_pressed = false;
    private int mouse_button = -1; // -1: released 0: right pressed 1: left pressed
    private ArrayList<Point> pressed_points = new ArrayList<>();
    public Color cursor_color = Color.orange;
    public int mode = 0; //0: edit mode 1: sim mode
    public Hashtable<ArrayList<Point>,Point> saved_roads = new Hashtable<>(); //a hash table to store directions and roads
    public ArrayList<Car> cars = new ArrayList<>();

    public Canvas(){
        super();
        setOpaque(false);

        //only listen mouse when in edit mode
        if(mode == 0) {
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    mouse_pressed = true;
                    if (SwingUtilities.isLeftMouseButton(e)) mouse_button = 0;
                    else if (SwingUtilities.isRightMouseButton(e)) mouse_button = 1;
                    else if (SwingUtilities.isMiddleMouseButton(e)) mouse_button = 2;

                    if(mouse_button==0) {
                        prev_placed_point = new Point(getMousePosition().x / 20 * 20, getMousePosition().y / 20 * 20);
                        pressed_points.add(prev_placed_point);
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    mouse_pressed = false;
                    mouse_button = -1;
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mouse_inside = true;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouse_inside = false;
                }
            });
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        construct(g);

        //only perform this mouse activity when in edit mode
        if(mode==0) {
            g.setColor(Color.orange.darker());
            for (ArrayList<Point> road_points : saved_roads.keySet()){
                for (Point p : road_points) g.fillRect(p.x + 1, p.y + 1, 18, 18);
            }
            g.setColor(Color.orange);
            for (Point p : pressed_points) {
                g.fillRect(p.x + 1, p.y + 1, 18, 18);
            }
            update_mouse_activity(g);
        }

        //only perform these activities when in sim mode
        else if(mode==1) {
            g.setColor(Color.orange);
            for (ArrayList<Point> road_points : saved_roads.keySet()) {
                for (Point p : road_points) g.fillRect(p.x + 1, p.y + 1, 18, 18);
            }

            //draw cars
            g.setColor(Color.cyan);
            for (Car car : cars) {
                Point pos = car.position;
                g.fillRect(pos.x + 1, pos.y + 1, 18, 18);
            }
        }
    }

    //initiate interface
    private void construct(Graphics g){
        //fill background
        int width = getWidth();
        int height = getHeight();
        g.setColor(COLOR.ideal_dark_opaque);
        g.fillRect(0,0, width/20*20, height/20*20);
        g.setColor(COLOR.ideal_dark_highlight_opaque);
        for(int i = 0; i < width/20; i++){
            for(int j = 0; j < height/20; j++){
                g.fillRect(i*20 + 1, j*20 + 1, 18, 18);
            }
        }
    }

    public void update_mouse_activity(Graphics g){

        //only update if mouse is inside our canvas
        if(mouse_inside && g!=null) {
            //get mouse loc
            try {
                mouse_loc.x = getMousePosition().x/20*20;
                mouse_loc.y = getMousePosition().y/20*20;
            }

            catch (Exception e){
                //empty catch to avoid mouse "drop out focus" bug in swing
            }

            //configure cursor
            if(mouse_button==1) cursor_color = Color.red;
            else if(mouse_button==0) cursor_color = Color.green;
            else cursor_color = Color.orange;
            g.setColor(cursor_color);
            g.fillRect(mouse_loc.x+1,mouse_loc.y+1,18,18);

            //perform tasks
            if(mouse_pressed){
                //figure out direction
                if(pressed_points.size()==1){
                    int x_bias = mouse_loc.x - prev_placed_point.x;
                    int y_bias = mouse_loc.y - prev_placed_point.y;
                    if(x_bias == 0 && y_bias == 0) return;
                    if(Math.abs(x_bias) >= Math.abs(y_bias)){
                        direction = new Point(x_bias/Math.abs(x_bias), 0);
                    }
                    else{
                        direction = new Point(0, y_bias/Math.abs(y_bias));
                    }
                }

                Point new_point = new Point(prev_placed_point.x + 20*direction.x, prev_placed_point.y + 20*direction.y);
                int move_dist = (mouse_loc.x - prev_placed_point.x) * direction.x + (mouse_loc.y - prev_placed_point.y) * direction.y;
                //only add when placement is legal(connected and new and one direction)
                if(mouse_button==0 && !pressed_points.contains(new_point)){
                    if(move_dist>=20)pressed_points.add(new_point); //left click adds
                    else if(move_dist<-20 && !pressed_points.isEmpty()) pressed_points.remove(pressed_points.size()-1);
                    if(!pressed_points.isEmpty()) prev_placed_point = pressed_points.get(pressed_points.size()-1); //update query reference
                }
                else if(mouse_button==1) pressed_points.clear(); //right click removes all

                //middle click confirms addition to map
                else if(mouse_button==2){
                    //store previous construct
                    saved_roads.put((ArrayList<Point>) pressed_points.clone(),direction);
                    //clean pressed points
                    pressed_points.clear();
                }
            }
        }
    }
}
