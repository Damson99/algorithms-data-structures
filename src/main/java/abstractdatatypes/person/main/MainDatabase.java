package abstractdatatypes.person.main;

import abstractdatatypes.person.Database;

public class MainDatabase {
    public static void main(String[] args) {
        Database db = new Database();
        db.addSorted("Wieczorek", 20_000);
        db.addSorted("Kowalski", 5_000);
        db.addSorted("Ziober", 2_000);
        db.addSorted("Bomber", 10_000);
        db.addSorted("Walaszak", 12_000);
        db.addSorted("Boner", 4_000);
        db.addSorted("Boner", 4_000);

        db.print("List of data - unsorted");
        db.printSortedBySalary("List of data - sorted by salary");
        db.printSortedBySurname("List of data - sorted by surname alphabetic");

        System.out.println("Deleting Boner...");
        db.remove("Boner");

        System.out.println("Deleting Ziober...");
        db.remove("Ziober");

        System.out.println();
        db.print("List of data - unsorted");
        db.printSortedBySalary("List of data - sorted by salary");
        db.printSortedBySurname("List of data - sorted by surname alphabetic");
    }
}
