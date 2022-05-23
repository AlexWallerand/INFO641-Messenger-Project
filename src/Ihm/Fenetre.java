package Ihm;

import javax.swing.*;
import java.awt.*;

public abstract class Fenetre extends JFrame {

    protected Container pan = getContentPane();
    protected final int width = 1000;
    protected final int height = 750;
    protected ImageIcon img = new ImageIcon("media/polytech-logo.png");

    public Fenetre(String title) throws HeadlessException {
        super();
        this.setResizable(false);
        this.setSize(width, height);
        this.setTitle(title);
        this.setIconImage(img.getImage());
    }
    public Boolean containsComponent(Container container, JComponent component) {
        for (Component containedComponent : container.getComponents()) {
            if (containedComponent == component) {
                return true;
            }
        }
        return false;
    }

}
