package br.academic.utils.events;

import br.academic.enums.EventModel;
import br.academic.utils.participant.*;
import java.util.HashMap;

public class Lecture extends Events {
    private String speaker;
    private int durationLecture;

    public Lecture(String title, String date, String place, int maxParticipants, String speaker, int durationLecture, String description, EventModel model, int ID) {
        super(title, date, place, maxParticipants, description, model, ID);
        this.speaker = speaker;
        this.durationLecture = durationLecture;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Speaker: " + speaker + " / Duration: " + durationLecture + "\n");
    }

    public boolean subscribePerson(Person person) {
        if(!(registered.size() < maxParticipants)) {
            System.err.println("Error: The event is already at full capacity.");
            return false;
        } 
        if (registered.containsKey(person.getCPF())) { 
        System.err.println("Error: Person is already subscribed to this lecture.");
        return false;
        }
        registered.put(person.getCPF(), person);

        return true;
    }
}