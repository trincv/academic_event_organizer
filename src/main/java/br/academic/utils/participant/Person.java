package br.academic.utils.participant;

public abstract class Person {
    protected String name;
    protected String email;
    protected int ID;

    public Person(String name, String email, int ID) {
        this.name = name;
        this.email = email;
        this.ID = ID;
    }

    public abstract String getCategory();

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return ID;
    }
    public void display() {
        System.out.println(name + " / " + email + " / " + ID);
    }

}