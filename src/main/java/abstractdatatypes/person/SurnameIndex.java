package abstractdatatypes.person;

public class SurnameIndex {
    Person ref;
    SurnameIndex next;

    public void printFurther(String s) {
        SurnameIndex tmp = this;
        while (tmp != null) {
            System.out.printf(" %12s earn \t%4d\n", tmp.ref.getSurname(), tmp.ref.getSalary());
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public Person getRef() {
        return this.ref;
    }

    public void setRef(Person ref) {
        this.ref = ref;
    }

    public SurnameIndex getNext() {
        return next;
    }

    public void setNext(SurnameIndex next) {
        this.next = next;
    }
}
