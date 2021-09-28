package abstractdatatypes.list.parallellist.main;

import abstractdatatypes.list.parallellist.TwoWayDataRecordList;

import static util.Logger.log;

public class TwoWayDataRecordListMain
{
    public static void main(String[] args) {
        TwoWayDataRecordList twoWayList=new TwoWayDataRecordList();
        twoWayList.addSorted("Wieczorek", 20);
        twoWayList.addSorted("Kowalski", 23);
        twoWayList.addSorted("Malinowski", 35);
        twoWayList.addSorted("Czekaj", 54);
        twoWayList.addSorted("Kosowska", 45);

        System.out.printf("Size = %d\n", twoWayList.size());
        log("List from beginning: "); twoWayList.print();

        log("Deleting record Kowalski..."); twoWayList.remove("Kowalski");
        log("Deleted");

        log("Deleting record Malinowski..."); twoWayList.remove("Malinowski");
        log("Deleted");

        System.out.printf("Size = %d\n", twoWayList.size());

        log("List from end: "); twoWayList.printFromEnd();
    }
}
