package codewars.impl.frame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(GamePanel panel, Dimension dm) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CodeWars");
        setBounds(100, 100, dm.width, dm.height);
        setContentPane(panel);
    }

}
