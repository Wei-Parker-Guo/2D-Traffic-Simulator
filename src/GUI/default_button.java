package GUI;

import javax.swing.*;
import java.awt.*;

//default button style
public class default_button extends JButton {
    private Color hoverBackgroundColor = COLOR.ideal_dark_highlight;
    private Color pressedBackgroundColor = Color.cyan.darker();

    public default_button() {
        this(null);
    }

    public default_button(String text) {
        super(text);
        super.setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(null);
        setOpaque(false);
        setBorderPainted(false);
        setFont(FONT.NORMAL_TEXT);
        setBackground(COLOR.ideal_dark);
        setForeground(Color.WHITE);
        setHoverBackgroundColor(hoverBackgroundColor);
        setPressedBackgroundColor(pressedBackgroundColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}
