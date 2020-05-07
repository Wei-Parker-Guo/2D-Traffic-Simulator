package GUI;

import TrafficSim.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel {

    //attributes
    private int[] mouse_loc = {0,0};
    private boolean mouse_inside = false;
    private boolean mouse_pressed = false;
    private ArrayList<Point> pressed_points = new ArrayList<>();

    public Canvas(){
        super();
        setOpaque(false);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouse_pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouse_pressed = false;
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        construct(g);
        update_mouse_activity(g);
        for(Point p : pressed_points){
            g.setColor(Color.orange);
            g.fillRect(p.x + 1, p.y + 1, 18, 18);
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
                mouse_loc[0] = getMousePosition().x/20*20;
                mouse_loc[1] = getMousePosition().y/20*20;
            }

            catch (Exception e){

            }

            g.setColor(Color.orange);
            g.fillRect(mouse_loc[0]+1,mouse_loc[1]+1,18,18);

            if(mouse_pressed){
                Point new_point = new Point(mouse_loc[0], mouse_loc[1]);
                pressed_points.add(new_point);
            }
        }

    }

    //update cars
    public void update_vehicles(ArrayList<Car> vehicles){

    }
}
