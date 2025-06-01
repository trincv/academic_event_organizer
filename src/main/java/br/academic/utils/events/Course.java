package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class Course extends Events {


    public Course(String title, String date, String place, int max_participants, String description) {
        super(title, date, place, max_participants, description);
    }

    @Override
    public void displayEvent() {
        System.out.println("Type: Course!");
        super.displayEvent();
    }

    public boolean SubscribePerson(Object obj) {
        return true;
    }

    public void getAllSubscribed() {
        System.out.print(" ");
    }
}