package br.academic.utils.events;

import br.academic.enums.EventModel;
import br.academic.interfaces.IDisplayable;
import br.academic.utils.participant.*;
import java.util.HashMap;

public abstract class Events implements IDisplayable {
    private EventModel model;
    private int ID;
    private String title;
    private String date;
    private String place;
    protected int maxParticipants;
    private String description;
    protected HashMap<String, Person> registered = new HashMap<>();

    public Events(String title, String date, String place, int maxParticipants, String description, EventModel model, int ID) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.maxParticipants = maxParticipants;
        this.description = description;
        this.model = model;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    @Override
public void display() {
    System.out.println("[" + this.getClass().getSimpleName() + "] ID: " + ID + " / Title: " + title + " / Model: " +  model + " / Date: " + date + " / Place: " + place);
    System.out.println("Total Participants: " + maxParticipants + " / Current Subscribed: " + registered.size());
    System.out.println("Description: " + description);
}

    public void getAllSubscribed() {
        for(String key : registered.keySet()) {
            registered.get(key).display();
        }
    }

    public abstract boolean subscribePerson(Person person);

}
