package abstractdatatypes.person;

import static util.Logger.log;

public class PersonRecords
{
    private Person head, tail;

    public Person addToEnd(String surname, int salary){
        if(!surname.equals("") && salary>=0){
            Person newPerson = new Person(surname, salary);
            if(head==null){
                head=newPerson;
            }
            else{
                tail.setNextPerson(newPerson);
                newPerson.setNextPerson(null);
            }
            tail=newPerson;
            return newPerson;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public void printResults(String listName){
        if(head!=null)
            head.printFurther(listName);
        else
            System.out.printf("PersonRecords %s is empty\n", listName);
    }

    public PersonRecords removeUnsorted(String surname){
        Person tmp=head, prev=null;
        boolean isFind=false;
        while (tmp!=null){
            if(tmp.getSurname().equals(surname)){
                isFind=true;
                break;
            }
            else{
                prev=tmp;
                tmp=tmp.getNextPerson();
            }
        }
        if(!isFind){
            log("Record does not found for: " + surname);
            return this;
        }
        if(prev==null && tmp.getNextPerson()==null) {
            head=null;
            tail=null;
            return this;
        }
        if(prev==null && tmp.getNextPerson()!=null){
            head=tmp.getNextPerson();
            return this;
        }
        if(prev!=null && tmp.getNextPerson()==null){
            prev.setNextPerson(null);
            tail=prev;
            return this;
        }
        prev.setNextPerson(tmp.getNextPerson());
        return this;
    }
}
