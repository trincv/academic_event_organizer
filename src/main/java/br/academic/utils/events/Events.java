package br.academic.utils.events;

import java.util.HashMap;
import br.academic.utils.participant.*;

public abstract class Events {
    private String title;
    private String date;
    private String place;
    protected int max_participants;
    protected int subscribed;
    private String description;
    protected HashMap<Integer, Person> registered = new HashMap<>();

    public Events(String title, String date, String place, int max_participants, String description) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.max_participants = max_participants;
        this.description = description;
    }

    public void displayEvent() {
        System.out.print(title + "\n" + date + "\n" + place + "\n" + max_participants + "\n" + subscribed + "\n" + description + "\n" );
    }

    public abstract boolean SubscribePerson(Object obj);

    public abstract void getAllSubscribed();

}