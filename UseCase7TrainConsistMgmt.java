import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UseCase7TrainConsistMgmt {

    static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("====================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        Collections.sort(bogies, new Comparator<Bogie>() {
            @Override
            public int compare(Bogie b1, Bogie b2) {
                return Integer.compare(b1.getCapacity(), b2.getCapacity());
            }
        });

        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}
