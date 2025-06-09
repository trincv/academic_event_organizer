package br.academic.views.reports;

import br.academic.core.App;
import br.academic.utils.participant.*;


public class ReportsView {

    public static void mainReport() {
        int option = 1;

        while (option != 0) {

            App.clearScreen();
            System.out.println("-------- Reports managment -------\n");

            System.out.println("0 - Return");
            System.out.println("1 - Search especific person");
            System.out.println("2 - Show event view");
            System.out.println("3 - Generate cetificate");
            System.out.print("\nChoose an option: ");

            do {
                option = App.sc.nextInt();
                App.sc.nextLine();

                if(option < 0 || option > 3) System.out.print("Invalid option. Digit again: ");

            } while(option < 0 || option > 3);

            switch (option) {
                case 1: {
                    int cpf;
                    Person p = null;
                    App.clearScreen();
                    System.out.print("\nInsert the person's CPF: ");

                    do {
                        
                        p = App.pe.searchPerson(App.sc.nextLine());

                        if(p == null) System.out.print("Invalid CPF, digit again: ");

                    } while(p == null);

                    System.out.print("\n");

                    p.display();

                    System.out.println("\nPress enter to return.");
                    App.sc.nextLine();

                    break;
                } 
                case 2: {
                    EventView.viewEvent();
                    break;
                }
                case 3: {
                    break;
                }
                case 0: {
                    App.clearScreen();
                    break;
                }
            }
        }
    }
}