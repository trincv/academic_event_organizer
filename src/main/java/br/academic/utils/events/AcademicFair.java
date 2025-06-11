package br.academic.utils.events;

import br.academic.enums.EventModel;
import br.academic.utils.participant.*;
import java.util.HashMap;

public class AcademicFair extends Events {
    private boolean openToPublic;
    private int numberOfOrganizations;

    public AcademicFair(String title, String date, String place, int maxParticipants, boolean openToPublic, int numberOfOrganizations, String description, EventModel model, int ID) {
        super(title, date, place, maxParticipants, description, model, ID);
        this.openToPublic = openToPublic;
        this.numberOfOrganizations = numberOfOrganizations;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Open to public: " + (openToPublic ? "Yes" : "No") + " / Number of organizations: " + numberOfOrganizations + "\n");
    }

    public boolean subscribePerson(Person person) {
        if(openToPublic == false)
            if((person instanceof External)) {
                System.err.println("Error: The person is an external and the event is close for public.");
                return false;
            }
        if(!(registered.size() < maxParticipants)){
            System.err.println("Error: The event is already at full capacity.");
            return false;
        } 
        if (registered.containsKey(person.getCPF())) { 
        System.err.println("Error: Person is already subscribed to this academic fair.");
        return false;
        }
        registered.put(person.getCPF(), person);

        return true;
    }
}