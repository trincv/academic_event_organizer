package br.academic.utils.events;




public class EventsManagment {
  private HashMap<String, Events> searchTitle = new HashMap<>();
  
  public boolean addEvent(Object o) {
    if(!(o instanceof Events)) return 0;
    searchTitle.put(o.getTitle(), o);
  }
  
  public boolean removeEvent(Object o) {
    if(!(o instanceof Events)) return 0;
    
  }
  public boolean searchEvent(Object o) {
    if(!(o instanceof Events)) return 0;
    
  }
  
  
}
