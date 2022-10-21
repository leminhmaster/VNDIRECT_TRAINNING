import awt.AWTSimple1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTSimple {
    public static void main(String[] args) {
//        Frame screen = new Frame();
//        screen.setLayout(null);
//        Panel panel = new Panel();
//        panel.setBounds(30,60,70,70);
//        panel.setBackground(Color.RED);
//
//        screen.add(panel);
//        screen.setSize(300,200);
//        screen.setVisible(true);
        Frame screen = new AWTSimple1();
        screen.setSize(500,500);
        screen.setVisible(true);
//        screen.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(1);
//            }
//        });
        screen.addWindowListener((WindowClosing) w->System.exit(1));

    }
}
