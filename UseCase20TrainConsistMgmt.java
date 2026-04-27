public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC20 - Exception Handling During Search Operations");
        System.out.println("====================================\n");

        String[] bogieIds = {};
        String searchId = "BG101";

        validateBogieData(bogieIds);

        boolean found = false;
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }
    }

    private static void validateBogieData(String[] bogieIds) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }
    }
}
