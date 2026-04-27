import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmt {

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
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("====================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("\nBogie Type: " + type);
            list.forEach(b -> System.out.println("    Capacity -> " + b.getCapacity()));
        });

        System.out.println("\nUC9 grouping completed...");
    }
}
