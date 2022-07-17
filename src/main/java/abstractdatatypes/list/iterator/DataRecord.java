package abstractdatatypes.list.iterator;

public class DataRecord {
    private final char value;
    private DataRecord next;

    public void print() {
        System.out.print(value + " ");
    }

    public DataRecord(char value) {
        this.value = value;
    }

    public DataRecord getNext() {
        return next;
    }

    public void setNext(DataRecord next) {
        this.next = next;
    }

    public char getValue() {
        return value;
    }
}
