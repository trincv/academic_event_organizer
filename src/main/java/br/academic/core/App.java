package br.academic.core;

import java.util.Scanner;
import br.academic.managment.*;
import br.academic.views.ApplicationView;

public class App 
{
    public static final Scanner sc = new Scanner(System.in);
    public static EventsManagment ev = new EventsManagment();
    public static PersonManagment pe = new PersonManagment();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main( String[] args )
    {
        clearScreen();
        ApplicationView.mainView();
        clearScreen();
    }
}
