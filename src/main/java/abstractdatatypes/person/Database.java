package abstractdatatypes.person;

import abstractdatatypes.Status;
import util.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.Logger.*;

public class Database
{
    private final static ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final PersonRecords personRecords = new PersonRecords();
    private SurnameIndex headSurname, tailSurname;
    private SalaryIndex headSalary, tailSalary;

    public void add(String surname, int salary)
    {
        Person newRef = personRecords.addToEnd(surname, salary);
        CompletableFuture<SalaryIndex> cfSalaryInx = CompletableFuture.supplyAsync(()->addSortedSalary(newRef), threadPool);
        CompletableFuture<SurnameIndex> cfSurnameInx = CompletableFuture.supplyAsync(()->addSortedSurname(newRef), threadPool);
        cfSalaryInx.join();
        cfSurnameInx.join();
    }

    public void remove(String surname)
    {
        CompletableFuture.supplyAsync(()->personRecords.removeUnsorted(surname), threadPool);
        CompletableFuture.supplyAsync(()->removeSortedBySalary(surname), threadPool);
        CompletableFuture.supplyAsync(()->removeSortedBySurname(surname), threadPool);
    }

    public void shutDownThreadPool()
    {
        threadPool.shutdown();
    }

    public void printSortedBySurname(String s)
    {
        log(s);
        if(headSurname!=null)
            this.headSurname.printFurther(s);
        else log("List is empty");
    }

    public void printSortedBySalary(String s){
        log(s);
        if(headSalary!=null)
            this.headSalary.printFurther(s);
        else log("List is empty");
    }

    public void print(String s) {
        personRecords.printResults(s);
    }

    private Database removeSortedBySalary(String surname)
    {
        SalaryIndex tmp=headSalary, prev=null;
        boolean isFind=false;
        while(tmp!=null){
            if(tmp.getRef().getSurname().equals(surname)){
                isFind=true;
                break;
            }
            else{
                prev=tmp;
                tmp=tmp.getNext();
            }
        }
        if(!isFind){
            log("SalaryIndex record does not found for:" + surname);
            return this;
        }
        else if(prev==null && tmp.getNext()==null){
            headSalary=null;
            tailSalary=null;
            return this;
        }
        else if(prev==null && tmp.getNext()!=null){
            headSalary=tmp.getNext();
            return this;
        }
        else if(prev!=null && tmp.getNext()==null){
            prev.setNext(null);
            headSalary=prev;
            return this;
        }
        else{
            prev.setNext(tmp.getNext());
            return this;
        }
    }

    private Database removeSortedBySurname(String surname)
    {
        SurnameIndex tmp=headSurname, prev=null;
        boolean isFind=false;
        while(tmp!=null){
            if(tmp.getRef().getSurname().equals(surname)){
                isFind=true;
                break;
            }
            else{
                prev=tmp;
                tmp=tmp.getNext();
            }
        }
        if(!isFind){
            log("SurnameIndex record does not found for:" + surname);
            return this;
        }
        else if(prev==null && tmp.getNext()==null){
            headSurname=null;
            tailSurname=null;
            return this;
        }
        else if(prev==null && tmp.getNext()!=null){
            headSurname=tmp.getNext();
            return this;
        }
        else if(prev!=null && tmp.getNext()==null){
            prev.setNext(null);
            headSurname=prev;
            return this;
        }
        else{
            prev.setNext(tmp.getNext());
            return this;
        }
    }

    public SurnameIndex addSortedSurname(Person newRef)
    {
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

    public SalaryIndex addSortedSalary(Person newRef)
    {
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
