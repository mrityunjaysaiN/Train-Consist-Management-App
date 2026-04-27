import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("====================================\n");

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchId = "BG309";

        System.out.println("Original Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Ensure input is sorted before binary search
        Arrays.sort(bogieIds);

        System.out.println("\nSorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = binarySearch(bogieIds, searchId);

        System.out.println();
        if (found) {
            System.out.println("Bogie " + searchId + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + searchId + " not found using Binary Search.");
        }

        System.out.println("\nUC19 search completed...");
    }

    public static boolean binarySearch(String[] sortedArray, String key) {
        if (sortedArray == null || sortedArray.length == 0 || key == null) {
            return false;
        }

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(sortedArray[mid]);

            if (comparison == 0) {
                return true;
            }
            if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
