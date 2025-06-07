package br.academic.core;

import java.util.Scanner;
import br.academic.utils.participant.PersonManagment;
import br.academic.utils.events.EventsManagment;
import br.academic.views.ApplicationView;

public class App 
{
    public static final Scanner sc = new Scanner(System.in);
    public static EventsManagment ev = new EventsManagment();
    public static PersonManagment pe = new PersonManagment();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main( String[] args )
    {

        ApplicationView.mainView();
        clearScreen();
        // Student s1 = new Student("Luiz Carlos", "luiz@gmail.com", 192938);
        // Student s2 = new Student("Fernando Amorim", "Fernando@gmail.com", 1902138);
        // External e1 = new External("Ruam Silva", "Ruam@gmail.com", 988762938);
        // Professor p1 = new Professor("Kirito abu", "Abu@gmail.com", 20003938);
        
        // // s1.display();
        // // s2.display();
        // // e1.display();
        // // p1.display();
    
        // Workshop w1 = new Workshop("Luz e Energia", "27/10/2010", "Praça da Sé", 50, "Enxada, pedra e lápis", "Luiz Magalhães", "No descrition added");
        // ev.addEvent(w1);
        // Course c1 = new Course("IA e Tecnologia", "23/10/2010", "Avenida Magalhães", 20, 48, p1, "Venham para meu curso");
        // ev.addEvent(c1);




        // // w1.displayEvent();
        // if(w1.AddPerson(s1) == false) System.out.println("Aluno " + s1.getName() + "não pôde ser inscrito no evento: " + w1.getTitle());
        //     System.out.println("Aluno " + s1.getName() + "foi inscrito no evento: " + w1.getTitle());
        // if(w1.AddPerson(s2) == false) System.out.println("Aluno " + s2.getName() + "não pôde ser inscrito no evento: " + w1.getTitle());
        //     System.out.println("Aluno " + s2.getName() + "foi inscrito no evento: " + w1.getTitle());

        // w1.displayEvent();

        // w1.getAllSubscribed();

        // if(c1.AddPerson(s1) == false) System.out.println("Aluno " + s1.getName() + "não pôde ser inscrito no evento: " + c1.getTitle());
        //     System.out.println("Aluno " + s1.getName() + "foi inscrito no evento: " + c1.getTitle());
        
        // if(c1.AddPerson(e1) == false) System.out.println("Externo " + e1.getName() + "não pôde ser inscrito no evento: " + c1.getTitle());
        //     System.out.println("Externo " + e1.getName() + "foi inscrito no evento: " + c1.getTitle());
        
        // c1.displayEvent();
        // c1.getAllSubscribed();

        // ev.searchEvent("Luz e Energia").displayEvent();
    
    
    }
}
