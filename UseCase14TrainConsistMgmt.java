import java.util.ArrayList;
import java.util.List;

public class UseCase14TrainConsistMgmt {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        private final String name;
        private final int capacity;

        public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
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
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("====================================\n");

        List<PassengerBogie> bogies = new ArrayList<>();
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            bogies.add(validBogie);
            System.out.println("Created Bogie: " + validBogie);

            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);
            bogies.add(invalidBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}
