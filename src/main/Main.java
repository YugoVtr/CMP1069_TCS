package main;

import singleton.CaldeiraWindow;

public class Main {

    public static void main(String[] args) {
        try {
            CaldeiraWindow.main(args);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
