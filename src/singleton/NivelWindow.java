package singleton;

import singleton.Caldeira;
import singleton.Window;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class NivelWindow extends Window {

	private Caldeira caldeira = Caldeira.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NivelWindow window = new NivelWindow();
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
	public NivelWindow() {
		initialize();
		display("right"); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Nivel");
	}

}
