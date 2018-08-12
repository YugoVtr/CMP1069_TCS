package singleton;

import singleton.Caldeira;
import singleton.Window;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class TemperaturaWindow {

	private JFrame frame;
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
		Window.display(this.frame,"left"); 
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
