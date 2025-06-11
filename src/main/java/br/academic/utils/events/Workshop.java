package br.academic.utils.events;

import br.academic.enums.EventModel;
import br.academic.utils.participant.*;
import java.util.HashMap;

public class Workshop extends Events {
    private String toolsRequired;
    private String instructor;


    public Workshop(String title, String date, String place, int maxParticipants, String toolsRequired, String instructor, String description, EventModel model, int ID) {
        super(title, date, place, maxParticipants, description, model, ID);
        this.toolsRequired = toolsRequired;
        this.instructor = instructor;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("instructor: " + instructor + " / Tools required: " + toolsRequired + "\n");        
    }

    public boolean subscribePerson(Person person) {
        if(!(registered.size() < maxParticipants)) {
            System.err.println("Error: The event is already at full capacity.");
            return false;
        }
        if (registered.containsKey(person.getCPF())) { 
        System.err.println("Error: Person is already subscribed to this workshop.");
        return false;
        }
        registered.put(person.getCPF(), person);

        return true;
    }
}