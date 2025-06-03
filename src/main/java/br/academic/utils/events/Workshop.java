package br.academic.utils.events;

import java.util.HashMap;
import br.academic.utils.participant.*;

public class Workshop extends Events {
    private String toolsRequired;
    private String instructor;


    public Workshop(String title, String date, String place, int max_participants, String toolsRequired, String instructor, String description) {
        super(title, date, place, max_participants, description);
        this.toolsRequired = toolsRequired;
        this.instructor = instructor;
    }

    @Override
    public void displayEvent() {
        System.out.println("Type: Workshop!\n" + "instructor: " + instructor + "\nTools required: " + toolsRequired);        
        super.displayEvent();
    }

    public boolean AddPerson(Object obj) {

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