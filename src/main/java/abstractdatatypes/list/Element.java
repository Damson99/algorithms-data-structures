package abstractdatatypes.list;

//lista jednokierunkowa
public class Element {
    private int value;
    private Element next;

    public Element(int value) {
        this.value = value;
        this.next = null;
    }

    public Element getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void printFurther(String listName) {
        Element tmp = this;
        System.out.printf("Further elements: %s", listName);
        while (tmp != null)
        {
            System.out.printf(" %d", tmp.value);
            tmp = tmp.next;
        }
        System.out.println();
    }
}
