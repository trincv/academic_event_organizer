package br.academic.managment;

import java.util.HashMap;
import br.academic.utils.participant.*;

public class PersonManagment {
    private HashMap<String, Person> personCod = new HashMap<>();
    
    public boolean addPerson(Person person) {
        personCod.put(person.getCPF(), person);
        return true;
      }
      
      public boolean removePerson(Person person) {
        personCod.remove(person.getCPF());
        return true;
      }

      public Person searchPerson(String CPF) {
        return personCod.get(CPF);
      }

}