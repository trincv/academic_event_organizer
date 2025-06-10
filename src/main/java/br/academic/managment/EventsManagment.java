package br.academic.managment;

import java.util.HashMap;
import java.util.ArrayList;
import br.academic.utils.events.*;

public class EventsManagment {
  private HashMap<Integer, Events> eventsIdMap = new HashMap<>();
  private ArrayList<Events> eventsList = new ArrayList<>();
    
  public boolean addEvent(Events event) {
      eventsIdMap.put(event.getID(), event);
      eventsList.add(event);
      return true;
  }
      
  public boolean removeEvent(Events event) {
    eventsIdMap.remove(event.getID());
    eventsList.remove(event);
    return true;
  }
    
  public Events searchEvent(int ID) {
    return eventsIdMap.get(ID);
  }

  public void showEventsByDate(String userDate) {
    int eventsCounter = 0;
    for(Events event : eventsList) 
      if (event.getDate().equals(userDate)) {
        System.out.print("\n");
        event.display();
        eventsCounter++;    
      }
    if (eventsCounter == 0) System.out.println("\nThere aren't events registered that day.");
  }

  public void showEventsByType(String userType) {
    int eventsCounter = 0;
    for(Events event : eventsList) 
      if (event.getClass().getSimpleName().trim().equalsIgnoreCase(userType.trim())) {
        System.out.print("\n");
        event.display();
        eventsCounter++;    
      }
    if (eventsCounter == 0) System.out.println("\nThere aren't events from that type registered.");
  }
}
