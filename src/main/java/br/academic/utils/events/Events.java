package br.academic.utils.events;

import java.util.HashMap;
import br.academic.utils.participant.*;

public abstract class Events {
    private EventModel model;
    private int ID;
    private String title;
    private String date;
    private String place;
    protected int max_participants;
    private String description;
    protected HashMap<String, Person> registered = new HashMap<>();

    public Events(String title, String date, String place, int max_participants, String description, EventModel model, int ID) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.max_participants = max_participants;
        this.description = description;
        this.model = model;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public void displayEvent() {
        System.out.print("[" + this.getClass().getSimpleName() + "] " + "ID: " + ID + " / Title: " + title  + " / Date: " + date + " / Place: " + place +" / Total participants: " + max_participants + " / Current subscribed: " + registered.size() + " / Description: " + description + "\n" );
    }

    public void setType() {
        
    }

    public abstract boolean addPerson(Object obj);

    public abstract void getAllSubscribed();

}
