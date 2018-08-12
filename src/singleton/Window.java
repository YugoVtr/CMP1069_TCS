package singleton;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window {

	protected JFrame frame;

	protected void display(String position) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screen_height = (int) screenSize.getHeight();
		int frame_width = (int) this.frame.getWidth();
		int x = frame_width + (int) (frame_width * 0.3);
		int y = screen_height / 4;
		
		switch (position) {
		case "left":
			x *= 0;
			break;
			
		case "right":
			x *= 2;
			break;

		default:
			x *= 1;
			break;
		}
		this.frame.setLocation(x, y);
	}

}
