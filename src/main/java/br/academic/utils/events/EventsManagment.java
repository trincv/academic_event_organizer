package br.academic.utils.events;

import java.util.HashMap;
//import br.academic.utils.events;

public class EventsManagment {
    private HashMap<String, Events> searchTitle = new HashMap<>();
    
    public boolean addEvent(Object o) {
        if(!(o instanceof Events)) return false;
        Events e = (Events) o;
        searchTitle.put(e.getTitle(), e);
        return true;
      }
      
      public boolean removeEvent(Object o) {
        if(!(o instanceof Events)) return false;
        Events e = (Events) o;
        searchTitle.remove(e.getTitle());
        return true;
      }
      public Events searchEvent(String title) {
        return searchTitle.get(title);
      }
}