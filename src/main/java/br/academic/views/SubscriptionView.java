package br.academic.views;

import br.academic.core.App;
import br.academic.utils.validations.*;
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

            person = App.pe.searchPerson(CpfValidation.getValidCpfInput());

            if(person == null) System.err.print("Person not found. Digit again: ");

        } while(person == null);

        System.out.print("\nInsert the event's ID: ");

        do {

            event = App.ev.searchEvent(InputInt.scanInt());

            if(event == null) System.err.print("Event not found. Digit again: ");

        } while(event == null);

        if(person.isSubscribed(event) == true) {
            System.err.println("That person is already subscribed at the event.");
            try{
                Thread.sleep(2 * 1000);
            } catch(Exception e) {}

            App.clearScreen();
            return;
        }

        if(event.subscribePerson(person) == true)
            if(person.subscribeInEvent(event) == true) {
                System.out.println("\nThe subscription was a sucess.");
                try{
                    Thread.sleep(2 * 1000);
                } catch(Exception e) {}

                App.clearScreen();
                return;
            }

        App.clearScreen();

        System.out.println("\nThe subscription was a failure.");

        try{
            Thread.sleep(2 * 1000);
        } catch(Exception e) {}

        App.clearScreen();
    }
}