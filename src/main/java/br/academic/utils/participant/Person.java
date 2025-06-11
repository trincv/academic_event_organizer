package br.academic.utils.participant;

import br.academic.interfaces.IDisplayable;
import br.academic.utils.events.*;
import java.util.ArrayList;
import java.util.List;

public class Person implements IDisplayable {
    private String name;
    private String email;
    private String CPF;
    private ArrayList<Events> subscribedInEvents = new ArrayList<>();

    public Person(String name, String email, String CPF) {
        this.name = name;
        this.email = email;
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean subscribeInEvent(Events event) {
        subscribedInEvents.add(event);
        return true;
    }

    public boolean isSubscribed(Events event) {
        for(Events eventID : subscribedInEvents) 
            if(eventID.getID() == event.getID())
                return true;
        
        return false;
    } 

    public List<Events> getAllSubscribedEvents() {
        return subscribedInEvents;
    }

    @Override
    public void display() {
        System.out.print("[" + this.getClass().getSimpleName() + "] " + "Name: " + name + " / Email: " + email + " / CPF: " + CPF + "\nID of events subscribed: ");
        subscribedInEvents.forEach(event -> System.out.print(event.getID() + " / "));
    }
}