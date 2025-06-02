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

        if(!(obj instanceof Person)) return false;
        if(!(obj instanceof External)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getId(), p);
        return true;
    }

    public void getAllSubscribed() {
        for(Integer key : registered.keySet()) {
            registered.get(key).display();
        }
    }
}