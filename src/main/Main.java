package main;
import singleton.Caldeira;

public class Main {

	public static void main(String[] args) {
		Caldeira caldeira = Caldeira.getInstancia();
		System.out.print(caldeira.toString());
	}

}
