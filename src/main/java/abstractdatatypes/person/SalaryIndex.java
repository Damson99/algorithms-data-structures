package abstractdatatypes.person;

public class SalaryIndex {
    Person ref;
    SalaryIndex next;

    public void printFurther(String s) {
        SalaryIndex tmp = this;
        while (tmp != null) {
            System.out.printf(" %12s earn \t%4d\n", tmp.ref.getSurname(), tmp.ref.getSalary());
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public Person getRef() {
        return ref;
    }

    public void setRef(Person ref) {
        this.ref = ref;
    }

    public SalaryIndex getNext() {
        return next;
    }

    public void setNext(SalaryIndex next) {
        this.next = next;
    }
}
