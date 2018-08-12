package singleton;

import singleton.Caldeira;
import singleton.Window;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class TemperaturaWindow extends Window {

	private Caldeira caldeira = Caldeira.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperaturaWindow window = new TemperaturaWindow();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TemperaturaWindow() {
		initialize();
		display("left"); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Temperatura");
	}

}
