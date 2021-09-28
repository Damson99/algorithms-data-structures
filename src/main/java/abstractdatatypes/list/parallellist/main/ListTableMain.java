package abstractdatatypes.list.parallellist.main;

import abstractdatatypes.array.ListTable;

import static util.Logger.log;

public class ListTableMain {
    public static void main(String[] args) {
        ListTable db = new ListTable();

        db.addPerson("Damian", 20);
        db.addPerson("Piotr", 40);
        log("============Print list: ");
        db.print();

        db.removePerson("Piotr");
        log("============Print list: ");
        db.print();

        db.addPersonAtIndex("hubert", 35, 40);
        log("============Print list: ");
        db.print();

        log("============Damian is at index: ");
        db.search("Damian");
    }
}
