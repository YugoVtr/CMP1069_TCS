package singleton;

public class Caldeira {

	// Attributes
	private static Caldeira instancia;
	private float temperaturaMax = 0;
	private float temperaturaMin = 0;
	private float nivelMax = 0;
	private float nivelMin = 0;
	private float temperaturaCorrente = 0;
	private float nivelCorrente = 0;

	// Methods
	private Caldeira() {}

	public static Caldeira getInstancia() {
		if (instancia == null) { 
			instancia = new Caldeira(); 
		}
		return instancia;
	}

	public void iniciar(float tMax, float tMin, float nMax, float nMin) {
		
	}
	
	@Override
	public String toString() {
		return "Caldeira [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	// Getters and Setters 
	public float getTemperaturaMax() {
		return temperaturaMax;
	}

	public float getTemperaturaMin() {
		return temperaturaMin;
	}

	public float getNivelMax() {
		return nivelMax;
	}

	public float getNivelMin() {
		return nivelMin;
	}

	public float getTemperaturaCorrente() {
		return temperaturaCorrente;
	}

	public float getNivelCorrente() {
		return nivelCorrente;
	}
}
