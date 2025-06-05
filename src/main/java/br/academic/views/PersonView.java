package br.academic.views;

import java.util.Scanner;
import br.academic.core.App;

public class PersonView {

    public static void register() {

        System.out.println("\n-- Register a Person --");
        System.out.print("Enter name: ");
        String name = App.sc.nextLine();

        System.out.print("Enter email: ");
        String email = App.sc.nextLine();

    }
}
