package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class Lecture extends Events {
    private String speaker;
    private int durationLecture;

    public Lecture(String title, String date, String place, int max_participants, String speaker, int durationLecture, String description, EventModel model, int ID) {
        super(title, date, place, max_participants, description, model, ID);
        this.speaker = speaker;
        this.durationLecture = durationLecture;
    }

    @Override
    public void displayEvent() {
        super.displayEvent();
        System.out.println("Speaker: " + speaker + " / Duration: " + durationLecture);
    }

    public boolean AddPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getCPF(), p);
        return true;
    }
    public void getAllSubscribed() {
        for(String key : registered.keySet()) {
            registered.get(key).displayPerson();
        }
    }
}