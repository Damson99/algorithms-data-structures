package abstractdatatypes.list.parallellist;

public class ArrayData {
    private final int maxSize=200;
    private int currentSize;
    private TwoWayDataRecord[] dataRecords;

    private int[] indexSurname;
    private int[] indexAge;
    private int[] indexSalary;

//    +2 - pierwszy index oznacza koniec listy a drugi pozostaje pusty
    public ArrayData(TwoWayDataRecord[] dataRecords, int[] indexSurname, int[] indexAge, int[] indexSalary) {
        this.dataRecords = new TwoWayDataRecord[maxSize+2];
        this.indexSurname = new int[maxSize+2];
        this.indexAge = new int[maxSize+2];
        this.indexSalary = new int[maxSize+2];
        currentSize=0;
    }


}
