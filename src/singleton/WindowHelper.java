package singleton;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class WindowHelper {
        
    public WindowHelper(){
        
    }
            
    public static void display(JFrame frame, String position) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frame_width = (int) frame.getWidth();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        
        switch (position) {
        case "left":
                x *= 0;
                break;

        case "right":
                x = (int) screenSize.getWidth() - frame_width;
                break;

        default:
                break;
        }
        frame.setLocation(x, y);
    }
}
