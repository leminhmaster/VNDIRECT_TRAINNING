import java.awt.*;

public class AWTSimple {
    public static void main(String[] args) {
        Frame frame =  new Frame();
        frame.setLayout(null);
        Panel panel = new Panel();
        panel.setBounds(30,60,50,70);
        panel.setBackground(Color.RED);
        frame.add(panel);
        frame.setSize(300,200);
        frame.setVisible(true);
    }
}