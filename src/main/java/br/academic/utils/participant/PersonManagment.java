package br.academic.utils.participant;

import java.util.HashMap;

public class PersonManagment {
    private HashMap<String, Person> personCod = new HashMap<>();

    public boolean addPerson(Object o) {
        if(!(o instanceof Person)) return false;
        Person e = (Person) o;
        personCod.put(e.getCPF(), e);
        return true;
      }
      
      public boolean removePerson(Object o) {
        if(!(o instanceof Person)) return false;
        Person e = (Person) o;
        personCod.remove(e.getCPF());
        return true;
      }

      public Person searchPerson(String CPF) {
        return personCod.get(CPF);
      }

}