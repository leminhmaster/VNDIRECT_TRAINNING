import javax.swing.*;
import java.awt.*;

public class SystemTrayExample {
    public static void main(String[] args) {
        SystemTray tray = SystemTray.getSystemTray();
        Icon icon = UIManager.getIcon("OptionPane.warningIcon");
        Image image = ((ImageIcon) icon).getImage();
        TrayIcon trayIcon = new TrayIcon(image,"Tray Demo",null);
        trayIcon.addActionListener(new ShowExampleActionListener());
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}
