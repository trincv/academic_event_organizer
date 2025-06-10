package br.academic.views;

import br.academic.core.App;
import br.academic.utils.events.*;
import br.academic.utils.participant.*;
import java.lang.Thread;
import java.lang.Exception;

public class SubscriptionView {

    public static void subscribe() {
        Person person = null;
        Events event = null;

        App.clearScreen();
        System.out.println("--------Subscribe person-------\n");
        System.out.print("Insert the person's CPF: ");

        do {

            person = App.pe.searchPerson(App.sc.nextLine());

            if(person == null) System.out.print("Invalid CPF. Digit again: ");

        } while(person == null);

        System.out.print("\nInsert the event's ID: ");

        do {

            event = App.ev.searchEvent(App.sc.nextInt());

            if(event == null) System.out.print("Invalid ID. Digit again: ");

        } while(event == null);

        App.clearScreen();

        if(event.subscribePerson(person) == false || person.subscribeInEvent(event) == false) System.out.println("The subscription was a failure.");
        else System.out.print("The subscription was a sucess.");

        try{
            Thread.sleep(2 * 1000);
        } catch(Exception e) {}

        App.clearScreen();
    }
}