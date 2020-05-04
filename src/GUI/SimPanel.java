package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimPanel extends JPanel implements ActionListener {

    //UI constructor
    public void construct(){
        //configure layout
        setLayout(new BorderLayout());
        JPanel bottom_panel = new JPanel(new GridLayout(1,0));
        bottom_panel.setBackground(COLOR.totally_transparent);
        setBackground(COLOR.totally_transparent);

        //play button
        default_button play_button = new default_button("Play");
        play_button.addActionListener(this);
        play_button.setActionCommand("play");

        bottom_panel.add(play_button);

        //pause button
        default_button pause_button = new default_button("Pause");
        pause_button.addActionListener(this);
        pause_button.setActionCommand("pause");

        bottom_panel.add(pause_button);

        //stop button
        default_button stop_button = new default_button("Stop");
        stop_button.addActionListener(this);
        stop_button.setActionCommand("stop");

        bottom_panel.add(stop_button);

        //content panel
        JPanel content_panel = new JPanel();
        content_panel.setBackground(COLOR.twenty_transparent);

        //add to main panel
        add(content_panel, BorderLayout.CENTER);
        add(bottom_panel, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch(cmd){
            case "play":
                break;
            case "pause":
                break;
            case "stop":
                break;
        }
    }
}
