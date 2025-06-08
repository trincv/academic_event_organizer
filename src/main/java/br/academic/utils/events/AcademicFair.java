package br.academic.utils.events;

import br.academic.utils.participant.*;
import java.util.HashMap;

public class AcademicFair extends Events {
    private boolean openToPublic;
    private int numberOfOrganizations;

    public AcademicFair(String title, String date, String place, int max_participants, boolean openToPublic, int numberOfOrganizations, String description, EventModel model, int ID) {
        super(title, date, place, max_participants, description, model, ID);
        this.openToPublic = openToPublic;
        this.numberOfOrganizations = numberOfOrganizations;
    }

    @Override
    public void displayEvent() {
        super.displayEvent();
        System.out.println("Open to public: " + openToPublic + " / Number of organizations: " + numberOfOrganizations);
    }

    public boolean addPerson(Object obj) {

        if(!(obj instanceof Person)) return false;
        if(openToPublic == false)
            if((obj instanceof External)) return false;
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