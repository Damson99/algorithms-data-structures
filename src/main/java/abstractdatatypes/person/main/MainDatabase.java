package abstractdatatypes.person.main;

import abstractdatatypes.person.Database;

import static util.Logger.log;

public class MainDatabase {
    public static void main(String[] args) {
        Database db = new Database();
        db.add("Wieczorek", 20_000);
        db.add("Kowalski", 5_000);
        db.add("Ziober", 2_000);
        db.add("Bomber", 10_000);
        db.add("Walaszak", 12_000);
        db.add("Boner", 4_000);

        db.print("List of data - unsorted");
        db.printSortedBySalary("List of data - sorted by salary");
        db.printSortedBySurname("List of data - sorted by surname alphabetic");

        log("Deleting Boner...");
        db.remove("Boner");

        log("Deleting Ziober...");
        db.remove("Ziober");

        System.out.println();
        db.print("List of data - unsorted");
        db.printSortedBySalary("List of data - sorted by salary");
        db.printSortedBySurname("List of data - sorted by surname alphabetic");
        db.shutDownThreadPool();
    }
}
