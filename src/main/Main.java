package main;
import singleton.CaldeiraWindow; 
import singleton.NivelWindow;
import singleton.TemperaturaWindow;

public class Main {

	public static void main(String[] args) {
		try {
			
			CaldeiraWindow.main(args);
			NivelWindow.main(args);
			TemperaturaWindow.main(args); 
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
