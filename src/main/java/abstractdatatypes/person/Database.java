package abstractdatatypes.person;

import abstractdatatypes.Status;

public class Database {
    private final PersonRecords personRecords = new PersonRecords();
    private SurnameIndex headSurname, tailSurname;
    private SalaryIndex headSalary, tailSalary;

    public void addSorted(String surname, int salary){
        Person newRef = personRecords.addToEnd(surname, salary);
        addSortedSalary(newRef);
        addSortedSurname(newRef);
    }

    public void remove(String s){
        personRecords.remove(s);
    }

    public void printSortedBySurname(String s){
        System.out.println(s);
        if(headSurname!=null)
            this.headSurname.printFurther(s);
        else System.out.println("List is empty");
    }

    public void printSortedBySalary(String s){
        System.out.println(s);
        if(headSalary!=null)
            this.headSalary.printFurther(s);
        else System.out.println("List is empty");
    }

    public void print(String s) {
        personRecords.printResults(s);
    }

    public SurnameIndex addSortedSurname(Person newRef) {
        SurnameIndex newPerson = new SurnameIndex();
        newPerson.setRef(newRef);
        if(headSurname==null){
            headSurname=newPerson;
            tailSurname=newPerson;
            newPerson.setNext(null);
            return newPerson;
        }
        String surname=newRef.getSurname();
        SurnameIndex prev=null, next=headSurname;
        Status status=Status.SEARCH;
        while (status==Status.SEARCH && next!=null){
            if(getSurname(next).compareTo(surname)>=0)
                status=Status.STOP;
            else{
                prev=next;
                next=next.getNext();
            }
        }
        if(prev==null){
            headSurname=newPerson;
            newPerson.setNext(next);
        }
        else if(next==null){
            tailSurname.setNext(newPerson);
            newPerson.setNext(null);
            tailSurname=newPerson;
        }
        else {
            prev.setNext(newPerson);
            newPerson.setNext(next);
        }
        return newPerson;
    }

    public SalaryIndex addSortedSalary(Person newRef) {
        SalaryIndex newPerson = new SalaryIndex();
        newPerson.setRef(newRef);
        if(headSalary==null){
            headSalary=newPerson;
            tailSalary=newPerson;
            newPerson.setNext(null);
            return newPerson;
        }
        int salary=newRef.getSalary();
        SalaryIndex prev=null, next=headSalary;
        Status status=Status.SEARCH;
        while (status==Status.SEARCH && next!=null){
            if(getSalary(next) >= salary)
                status=Status.STOP;
            else{
                prev=next;
                next=next.getNext();
            }
        }
        if(prev==null){
            headSalary=newPerson;
            newPerson.setNext(next);
        }
        else if(next==null){
            tailSalary.setNext(newPerson);
            newPerson.setNext(null);
            headSalary=newPerson;
        }
        else {
            prev.setNext(newPerson);
            newPerson.setNext(next);
        }
        return newPerson;
    }

    private String getSurname(SurnameIndex next) {
        return next.getRef().getSurname();
    }

    private int getSalary(SalaryIndex next) {
        return next.getRef().getSalary();
    }

}
