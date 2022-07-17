package abstractdatatypes.person;

import static util.Logger.log;

public class Person {
    private String surname;
    private int salary;
    private Person nextPerson;

    public Person(String surname, int salary) {
        this.surname = surname;
        this.salary = salary;
        this.nextPerson = null;
    }

    public void printFurther(String printListFromHere) {
        log(printListFromHere);
        Person tmp = this;
        while (tmp != null) {
            System.out.printf(" %12s earn \t%4d\n", tmp.getSurname(), tmp.getSalary());
            tmp = tmp.getNextPerson();
        }
        System.out.println();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }
}
