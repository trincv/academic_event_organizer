package br.academic.views;

import java.util.Scanner;
import br.academic.core.App;
import br.academic.utils.participant.*;

public class PersonView {

    public static void register() {
        int type_option;

        System.out.println("\n---- Register a Person ----");
        System.out.println("\nChoose the type of person:");

        do {
            System.out.println("0 - Student");
            System.out.println("1 - Professor");
            System.out.println("2 - External");

            type_option = App.sc.nextInt();
            App.sc.nextLine();

            if(type_option < 0 || type_option > 2) System.out.println("Invalid option, choose again:");

        } while(type_option < 0 || type_option > 2);

        System.out.print("Enter name: ");
        String name = App.sc.nextLine();

        System.out.print("Enter email: ");
        String email = App.sc.nextLine();

        System.out.print("Enter CPF: ");
        String CPF = App.sc.nextLine();

        switch(type_option) {
            case 0: {
                Student s = new Student(name, email, CPF);
                App.pe.addPerson(s);
                break;
            }
            case 1: {
                Professor p = new Professor(name, email, CPF);
                App.pe.addPerson(p);
                break;
            }
            case 2: {
                External e = new External(name, email, CPF);
                App.pe.addPerson(e);
                break;
            }
        }
    }
}
