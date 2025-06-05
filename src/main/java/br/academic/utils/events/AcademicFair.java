package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class AcademicFair extends Events {
    private boolean openToPublic;
    private int numberOfOrganizations;

    public AcademicFair(String title, String date, String place, int max_participants, boolean openToPublic, int numberOfOrganizations, String description, EventModel model) {
        super(title, date, place, max_participants, description, model);
        this.openToPublic = openToPublic;
        this.numberOfOrganizations = numberOfOrganizations;
    }

    @Override
    public void displayEvent() {
        System.out.println("Type: Academic fair!\n" + "Open to public: " + openToPublic + "\nNumber of organizations: " + numberOfOrganizations);
        super.displayEvent();
    }
    
    public boolean AddPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(openToPublic == false)
            if(!(obj instanceof Student)) return false;
        if(!(registered.size() < max_participants)) return false; 
        Person p = (Person) obj;
        registered.put(p.getCod(), p);
        return true;
    }

    public void getAllSubscribed() {
        for(Integer key : registered.keySet()) {
            registered.get(key).display();
        }
    }
}