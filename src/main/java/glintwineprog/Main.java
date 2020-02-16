package glintwineprog;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MainAppUi frame = new MainAppUi("GlintwineProg");

        //JFrame frame = new JFrame("GlintwineProg");
        //frame.setContentPane(new MainAppUi().mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image img = new ImageIcon(MainAppUi.class.getClassLoader().getResource("trayicon.gif")).getImage();
        frame.setIconImage(img);
        //frame.setMinimumSize(new Dimension(720, 450));
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
