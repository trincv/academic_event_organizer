package br.academic.utils.events;

import java.util.HashMap;
import br.academic.utils.participant.*;

public abstract class Events {
    private EventModel model;
    private String title;
    private String date;
    private String place;
    protected int max_participants;
    private String description;
    protected HashMap<Integer, Person> registered = new HashMap<>();

    public Events(String title, String date, String place, int max_participants, String description, EventModel model) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.max_participants = max_participants;
        this.description = description;
        this.model = model;
    }

    public String getTitle() {
        return title;
    }

    public void displayEvent() {
        System.out.print("Title: " + title + "\n" + "Date: " + date + "\n" + "Place: " + place + "\n" + "Total participants: " + max_participants + "\n" + "Current subscribed: " + registered.size() + "\n" + "Description: " + description + "\n" );
    }

    public void setType() {
        
    }

    public abstract boolean AddPerson(Object obj);

    public abstract void getAllSubscribed();

}
