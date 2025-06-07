package br.academic.views.reports;

import br.academic.core.App;


public class ReportsView {

    public static void mainReport() {
        int option;

        App.clearScreen();
        System.out.println("-------- Reports managment -------\n");

        System.out.println("0 - Return");
        System.out.println("1 - Person view");
        System.out.println("2 - Event view");
        System.out.println("3 - Generate cetificate");
        System.out.print("\nChoose an option: ");

        do {
            option = App.sc.nextInt();
            App.sc.nextLine();

            if(option < 0 || option > 3) System.out.print("Invalid option. Digit again: ");

        } while(option < 0 || option > 3);

        switch (option) {
            case 1: {
                break;
            } 
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 0: {
                break;
            }
        }

    }
}