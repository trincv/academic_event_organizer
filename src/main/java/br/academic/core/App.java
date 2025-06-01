package br.academic.core;

import br.academic.utils.participant.*;
import br.academic.utils.events.*;

public class App 
{
    public static void main( String[] args )
    {
        Student s1 = new Student("Luiz Carlos", "luiz@gmail.com", 192938);
        Student s2 = new Student("Fernando Amorim", "Fernando@gmail.com", 1902138);
        External e1 = new External("Ruam Silva", "Ruam@gmail.com", 988762938);
        Professor p1 = new Professor("Kirito abu", "Abu@gmail.com", 20003938);
        
        // s1.display();
        // s2.display();
        // e1.display();
        // p1.display();
    
        Workshop w1 = new Workshop("Luz e Energia", "27/10/2010", "Praça da Sé", 50, "No description added");

        // w1.displayEvent();
        w1.SubscribePerson(s1);
        w1.SubscribePerson(s2);

        w1.displayEvent();

        w1.getAllSubscribed();
    
    
    
    }
}
