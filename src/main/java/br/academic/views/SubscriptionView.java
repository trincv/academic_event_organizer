package br.academic.views;

import br.academic.core.App;
import br.academic.utils.events.*;
import br.academic.utils.participant.*;

public class SubscriptionView {

    public static void subscribe() {
        Person p = null;
        Events e = null;

        App.clearScreen();
        System.out.println("--------Subscribe person-------\n");
        System.out.print("Insert the person's CPF: ");

        do {

            p = App.pe.searchPerson(App.sc.nextLine());

            if(p == null) System.out.print("Invalid CPF. Digit again: ");

        } while(p == null);

        System.out.print("\nInsert the event's ID: ");

        do {

            e = App.ev.searchEvent(App.sc.nextInt());

            if(e == null) System.out.print("Invalid ID. Digit again: ");

        } while(e == null);

        if(e.addPerson(p) == false) System.out.println("The subscription was a failure.");
        else System.out.println("The subscription was a sucess.");

        System.out.println("\nPress enter to return.");
        App.sc.nextLine();

        App.clearScreen();
    }
}