package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel implements ActionListener {

    //attributes
    private String current_block = "road";
    private String current_intersection_type = "straight";
    //buttons
    private default_button road_button;
    private default_button light_button;
    private default_button intersect_button;
    private default_button straight_button;
    private default_button T_button;
    private default_button cross_button;

    //canvas
    public Canvas canvas = new Canvas();

    public void construct(){
        //edit layout
        setLayout(new BorderLayout());
        setBackground(COLOR.totally_transparent);
        JPanel line_end_panel = new JPanel(new GridLayout(0,1));
        line_end_panel.setBackground(COLOR.totally_transparent);
        line_end_panel.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));

        //building blocks
        JLabel building_block_label = new JLabel("Building Blocks");
        building_block_label.setFont(FONT.SUB_TITLE);
        building_block_label.setForeground(Color.WHITE);
        building_block_label.setHorizontalAlignment(JLabel.CENTER);

        line_end_panel.add(building_block_label);

        //road button
        road_button = new default_button("Road");
        road_button.addActionListener(this);
        road_button.setActionCommand("road");
        road_button.setBackground(Color.orange);

        line_end_panel.add(road_button);

        //Traffic Light button
        light_button = new default_button("Traffic Light");
        light_button.addActionListener(this);
        light_button.setActionCommand("light");

        line_end_panel.add(light_button);

        //intersection button
        intersect_button = new default_button("Intersection");
        intersect_button.addActionListener(this);
        intersect_button.setActionCommand("intersect");

        line_end_panel.add(intersect_button);

        //intersection toggles
        JLabel intersect_type_label = new JLabel(" Intersection Types ");
        intersect_type_label.setFont(FONT.SUB_TITLE);
        intersect_type_label.setForeground(Color.WHITE);
        intersect_type_label.setHorizontalAlignment(JLabel.CENTER);

        line_end_panel.add(intersect_type_label);

        //intersection toggles
        straight_button = new default_button("Straight");
        straight_button.addActionListener(this);
        straight_button.setActionCommand("straight");
        straight_button.setBackground(Color.green.darker());

        line_end_panel.add(straight_button);

        //intersection toggles
        T_button= new default_button("T Shaped");
        T_button.addActionListener(this);
        T_button.setActionCommand("T");

        line_end_panel.add(T_button);

        //intersection toggles
        cross_button = new default_button("Cross");
        cross_button.addActionListener(this);
        cross_button.setActionCommand("cross");

        line_end_panel.add(cross_button);


        //content panel
        JPanel content_panel = new JPanel(new BorderLayout());
        content_panel.setOpaque(false);

        //add all components to main
        content_panel.add(canvas);
        add(content_panel, BorderLayout.CENTER);
        add(line_end_panel, BorderLayout.LINE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        switch(cmd){
            case "road":
                current_block = "road";
                default_button.toggle_buttons(road_button, Color.orange, light_button, intersect_button);
                break;
            case "light":
                current_block = "light";
                default_button.toggle_buttons(light_button, Color.orange, road_button, intersect_button);
                break;
            case "intersect":
                current_block = "intersect";
                default_button.toggle_buttons(intersect_button, Color.orange, light_button, road_button);
                break;
            case "straight":
                current_intersection_type = "straight";
                default_button.toggle_buttons(straight_button, Color.green.darker(), T_button, cross_button);
                break;
            case "T":
                current_intersection_type = "T";
                default_button.toggle_buttons(T_button, Color.green.darker(), straight_button, cross_button);
                break;
            case "cross":
                current_intersection_type = "cross";
                default_button.toggle_buttons(cross_button, Color.green.darker(), T_button, straight_button);
                break;
        }

    }
}
