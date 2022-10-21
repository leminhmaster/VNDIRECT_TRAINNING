import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

public class RobotExample {
    public static void leftClick(Robot robot){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200);
    }

    public static void type(Robot robot,String s){
        byte[] bytes = s.getBytes();
        for (byte b: bytes) {
            int code = b;
            if (code > 96 && code <123) code = code-32;
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            robot.delay(2*1000);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            robot.mouseMove((int)dim.getWidth()/2,(int)dim.getHeight()/2);
            leftClick(robot);
            String userDir = System.getProperty("user.home");
            File file = new File(new File(userDir),"temp.txt");
            if (!file.exists()) file.createNewFile();
            Desktop.getDesktop().edit(file);
            robot.delay(500);
            type(robot,"Hello, world ksegfksgjdgfjgdkjfjhgdjkbvjhgsdjbvjgdjvbjhdgjfgjebjfgjbrjy");
            robot.delay(5*1000);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
