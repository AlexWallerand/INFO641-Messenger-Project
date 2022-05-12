package Ihm;

import javax.swing.*;
import java.awt.*;

public abstract class Fenetre extends JFrame {

    protected Container pan = getContentPane();
    protected final int width = 500;
    protected final int height = 500;

    public Fenetre(String title) throws HeadlessException {
        super();
        this.setSize(width, height);
        this.setTitle(title);
    }

}
