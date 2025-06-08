package br.academic.views.reports;

import br.academic.core.App;
import br.academic.utils.events.*;

public class EventView {

    public static void viewEvent() {
        
        int option;

        App.clearScreen();

        System.out.println("-------- Reports managment -------\n");

            
        System.out.println("0 - Return");
        System.out.println("1 - Search especific event");
        System.out.println("2 - Show all events in a date");
        System.out.println("3 - Show all events from a type");
        System.out.print("\nChoose an option: ");
            
        do {
            option = App.sc.nextInt();
            App.sc.nextLine();

            if(option < 0 || option > 3) System.out.print("Invalid value. Digit again: ");

        } while(option < 0 || option > 3);

        switch(option) {
            case 1: {
                Events e = null;

                App.clearScreen();
                System.out.print("\nInsert the event's ID: ");

                do {
                    
                    e = App.ev.searchEvent(App.sc.nextInt());
                    App.sc.nextLine();

                    if(e == null) System.out.print("Invalid ID. Digit again: ");

                } while(e == null);

                App.clearScreen();
                e.displayEvent();

                System.out.println("\nPress enter to return.");
                App.sc.nextLine();
            }
            case 0:{
                break;
            }
        }
    }
}