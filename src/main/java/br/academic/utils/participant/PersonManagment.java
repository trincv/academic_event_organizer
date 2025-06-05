package br.academic.utils.participant;

import java.util.HashMap;

public class PersonManagment {
    private HashMap<Integer, Person> personCod = new HashMap<>();

    public boolean addPerson(Object o) {
        if(!(o instanceof Person)) return false;
        Person e = (Person) o;
        personCod.put(e.getCod(), e);
        return true;
      }
      
      public boolean removePerson(Object o) {
        if(!(o instanceof Person)) return false;
        Person e = (Person) o;
        personCod.remove(e.getCod());
        return true;
      }

      public Person searchPerson(int Cod) {
        return personCod.get(Cod);
      }

}