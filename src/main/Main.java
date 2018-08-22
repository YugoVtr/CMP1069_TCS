package main;

//Singleton
import singleton.CaldeiraWindow;

//Iterator 
import iterator.ProfessorWindow; 

public class Main {

    public static void main(String[] args) {
        try {
            singleton(); 
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void singleton() {
        CaldeiraWindow.main(null);
    }
    
    private static void iterator() { 
        ProfessorWindow.main(null); 
    }

}
