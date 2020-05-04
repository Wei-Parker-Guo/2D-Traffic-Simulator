package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel implements ActionListener {

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
        default_button road_button = new default_button("Road");
        road_button.addActionListener(this);
        road_button.setActionCommand("road");

        line_end_panel.add(road_button);

        //Traffic Light button
        default_button light_button = new default_button("Traffic Light");
        light_button.addActionListener(this);
        light_button.setActionCommand("light");

        line_end_panel.add(light_button);

        //intersection button
        default_button intersect_button = new default_button("Intersection");
        intersect_button.addActionListener(this);
        intersect_button.setActionCommand("light");

        line_end_panel.add(intersect_button);

        //intersection roggles
        JLabel intersect_type_label = new JLabel(" Intersection Types ");
        intersect_type_label.setFont(FONT.SUB_TITLE);
        intersect_type_label.setForeground(Color.WHITE);
        intersect_type_label.setHorizontalAlignment(JLabel.CENTER);

        line_end_panel.add(intersect_type_label);

        //intersection toggles
        default_button straight_button = new default_button("Straight");
        straight_button.addActionListener(this);
        straight_button.setActionCommand("straight");

        line_end_panel.add(straight_button);

        //intersection toggles
        default_button T_button= new default_button("T Shaped");
        T_button.addActionListener(this);
        T_button.setActionCommand("T");

        line_end_panel.add(T_button);

        //intersection toggles
        default_button cross_button = new default_button("Cross");
        cross_button.addActionListener(this);
        cross_button.setActionCommand("cross");

        line_end_panel.add(cross_button);


        //content panel
        JPanel content_panel = new JPanel();
        content_panel.setBackground(COLOR.twenty_transparent);

        //add all components to main
        add(content_panel, BorderLayout.CENTER);
        add(line_end_panel, BorderLayout.LINE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
