package br.academic.utils.events;

import java.util.HashMap;
import br.academic.utils.participant.*;

public class Workshop extends Events {
    private String toolsRequired;
    private String instructor;


    public Workshop(String title, String date, String place, int max_participants, String toolsRequired, String instructor, String description, EventModel model, int ID) {
        super(title, date, place, max_participants, description, model, ID);
        this.toolsRequired = toolsRequired;
        this.instructor = instructor;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("instructor: " + instructor + " / Tools required: " + toolsRequired);        
    }

    public boolean addPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getCPF(), p);
        return true;
    }
}