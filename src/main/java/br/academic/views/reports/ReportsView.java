package br.academic.views.reports;

import br.academic.core.App;
import br.academic.utils.validations.*;
import br.academic.utils.participant.*;
import br.academic.utils.events.Events;
import java.util.List;

public class ReportsView {

    public static void mainReport() {
        int option;

        do {

            App.clearScreen();
            System.out.println("-------- Reports managment -------\n");

            System.out.println("0 - Return");
            System.out.println("1 - Search especific person");
            System.out.println("2 - Show event view");
            System.out.println("3 - Generate cetificate");
            System.out.print("\nChoose an option: ");

            option = InputInt.scanInt(0,3);

            switch (option) {
                case 1: {
                    int cpf;
                    Person person = null;
                    App.clearScreen();
                    System.out.print("\nInsert the person's CPF: ");

                    do {
                        
                        person = App.pe.searchPerson( CpfValidation.getValidCpfInput());

                        if(person == null) System.out.print("Person not found. Digit again: ");

                    } while(person == null);

                    System.out.print("\n");

                    person.display();

                    System.out.println("\nPress enter to return.");
                    App.sc.nextLine();

                    break;
                } 
                case 2: {
                    EventsReportsView.viewEventsReports();
                    break;
                }
                case 3: {
                    App.clearScreen();

                    Person person = null;

                    System.out.print("Digit the person's CPF: ");

                    do {

                        person = App.pe.searchPerson( CpfValidation.getValidCpfInput());
                        if(person == null) System.out.print("Person not found. Digit again: ");

                    } while(person == null);

                    List<Events> subscribedInEvents = person.getAllSubscribedEvents();

                    if(subscribedInEvents.size() == 0) {
                        System.out.println("This person isn't subscribed in any event\n");
                        System.out.print("Press anything to return\n");
                        App.sc.nextLine();
                        break;
                    }
                    System.out.println("Which event do you want to get the certificate of?:\n");
                    
                    for(Events event : subscribedInEvents) {
                        System.out.println("[" + event.getClass().getSimpleName() + "]" + " ID: " + event.getID() + " / Title: " + event.getTitle());
                    }

                    Events eventInput = null;

                    System.out.print("\nInsert the wanted event's ID: ");
                    do {
                        eventInput = App.ev.searchEvent(InputInt.scanInt());

                        if (eventInput == null || subscribedInEvents.contains(eventInput) == false) System.out.print("Event not found. Digit again: ");

                    } while(eventInput == null || subscribedInEvents.contains(eventInput) == false);

                    App.clearScreen();

                    System.out.println("-----------------CERTIFICATE-----------------\n\n");
                    System.out.println("This certificates that " + person.getName() + " concluded the event " + eventInput.getTitle() + "\nCongratulations!!\n\n");

                    System.out.println("Press antyhing to return");
                    App.sc.nextLine();
                    App.clearScreen();
                    break;
                }
                case 0: {
                    App.clearScreen();
                    break;
                }
            }
        } while(option != 0);
    }
}