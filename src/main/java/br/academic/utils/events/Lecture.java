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
        System.out.println("\nSpeaker: " + speaker + "\nDuration: " + durationLecture + "\n");
    }

    public boolean subscribePerson(Person person) {
        if(!(registered.size() < maxParticipants)) return false; 
        registered.put(person.getCPF(), person);
        return true;
    }
}