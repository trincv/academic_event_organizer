package br.academic.views;

import java.util.Scanner;
import br.academic.core.App;
import br.academic.views.reports.ReportsView;

public class ApplicationView {

    public static void mainView() {
        int option;

        do {
            System.out.println("\nIFBA");
            System.out.println("General system view:\n");
            System.out.println("0 - Close program");
            System.out.println("1 - Register a person");
            System.out.println("2 - Register an event");
            System.out.println("3 - Subscribe a person to an event");
            System.out.println("4 - Generate reports");
            System.out.print("\nChoose an option: ");

            option = App.sc.nextInt();
            App.sc.nextLine(); // consume leftover newline

            switch(option) {
                case 1:
                    PersonRegisterView.personRegister();
                    break;
                case 2:
                    EventRegisterView.eventRegister();
                    break;
                // case 3:
                //     SubscriptionView.subscribe();
                //     break;
                case 4:
                    ReportsView.mainReport();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while(option != 0);
    }

}
