package br.academic.utils.events;

import java.util.HashMap;
import java.util.Vector;

public class EventsManagment {
    private HashMap<Integer, Events> eventsID = new HashMap<>();
    private Vector<Events> eventsArray = new Vector<>();
    
    public boolean addEvent(Object o) {
        if(!(o instanceof Events)) return false;
        Events e = (Events) o;
        eventsID.put(e.getID(), e);
        eventsArray.add(e);
        return true;
      }
      
      public boolean removeEvent(Object o) {
        if(!(o instanceof Events)) return false;
        Events e = (Events) o;
        eventsID.remove(e.getID());
        eventsArray.remove(e);
        return true;
      }
      public Events searchEvent(int ID) {
        return eventsID.get(ID);
      }
}
