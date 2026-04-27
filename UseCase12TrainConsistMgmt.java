import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmt {

    static class GoodsBogie {
        private final String type;
        private final String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("====================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean safetyCompliant = goodsBogies.stream()
                .allMatch(bogie -> !"Cylindrical".equals(bogie.getType())
                        || "Petroleum".equals(bogie.getCargo()));

        System.out.println("\nSafety Compliance Status: " + safetyCompliant);
        if (safetyCompliant) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}
