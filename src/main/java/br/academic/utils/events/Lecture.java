package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class Lecture extends Events {

    private String speaker;

    public Lecture(String speaker, String title, String date, String place, int max_participants, String description) {
        super(title, date, place, max_participants, description);
        this.speaker = speaker;
    }

    @Override
    public void displayEvent() {
        System.out.println("Type: Lecture!\n" + "Speaker: " + speaker);
        super.displayEvent();
    }

    public boolean SubscribePerson(Object obj) {

        if(!(obj instanceof Person)) return false;
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