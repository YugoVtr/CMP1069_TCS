package singleton;

public class Caldeira {
	// Attributes
	private static Caldeira unicaInstancia;
	
	// Methods 
	private Caldeira() {}	
	public static Caldeira getInstancia() {
		if (unicaInstancia == null) 
			unicaInstancia = new Caldeira();
		return unicaInstancia; 
	}
	@Override
	public String toString() {
		return "Caldeira [getClass()=" + getClass() + 
				", hashCode()=" + hashCode() + 
				", toString()=" + super.toString()
				+ "]";
	}
}
