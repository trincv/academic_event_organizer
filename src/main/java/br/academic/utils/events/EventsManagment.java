package br.academic.utils.events;

import java.util.HashMap;

public class EventsManagment {
    private HashMap<String, Events> eventsTitle = new HashMap<>();
    
    public boolean addEvent(Object o) {
        if(!(o instanceof Events)) return false;
        Events e = (Events) o;
        eventsTitle.put(e.getTitle(), e);
        return true;
      }
      
      public boolean removeEvent(Object o) {
        if(!(o instanceof Events)) return false;
        Events e = (Events) o;
        eventsTitle.remove(e.getTitle());
        return true;
      }
      public Events searchEvent(String title) {
        return eventsTitle.get(title);
      }
}
