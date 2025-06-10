package br.academic.views.reports;

import br.academic.core.App;
import br.academic.utils.events.*;

public class EventsReportsView {

    public static void viewEventsReports() {
        
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
                Events event = null;

                App.clearScreen();
                System.out.print("\nInsert the event's ID: ");

                do {
                    
                    event = App.ev.searchEvent(App.sc.nextInt());
                    App.sc.nextLine();

                    if(event == null) System.out.print("Invalid ID. Digit again: ");

                } while(event == null);

                App.clearScreen();
                event.display();

                System.out.println("\nPress enter to return.");
                App.sc.nextLine();

                break;
            }
            case 2: {

                App.clearScreen();
                System.out.print("\nInsert the event's date: ");

                App.ev.showEventsByDate(App.sc.nextLine());

                System.out.println("\nPress enter to return.");
                App.sc.nextLine();

                break;
            }
            case 3: {

                App.clearScreen();
                System.out.print("\nInsert the event's type without spaces: ");

                App.ev.showEventsByType(App.sc.nextLine());

                System.out.println("\nPress enter to return.");
                App.sc.nextLine();

                break;

            }
            case 0:{
                break;
            }
        }
    }
}