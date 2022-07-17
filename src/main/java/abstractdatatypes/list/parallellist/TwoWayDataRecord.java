package abstractdatatypes.list.parallellist;

//lista dwukierunkowa - obudowana przez DataRecordList
public class TwoWayDataRecord {
    private String surname;
    private int age;
    private TwoWayDataRecord next;
    private TwoWayDataRecord prev;

    public TwoWayDataRecord(String surname, int age, TwoWayDataRecord next, TwoWayDataRecord prev) {
        this.surname = surname;
        this.age = age;
        this.next = next;
        this.prev = prev;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public TwoWayDataRecord getNext() {
        return next;
    }

    public void setNext(TwoWayDataRecord next) {
        this.next = next;
    }

    public TwoWayDataRecord getPrev() {
        return prev;
    }

    public void setPrev(TwoWayDataRecord prev) {
        this.prev = prev;
    }
}
