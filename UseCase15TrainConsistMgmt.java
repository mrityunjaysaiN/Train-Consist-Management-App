public class UseCase15TrainConsistMgmt {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        private final String shape;
        private String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                if ("Rectangular".equals(shape) && "Petroleum".equals(cargo)) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return shape + " bogie -> " + (cargo == null ? "No cargo" : cargo);
        }
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("====================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println();
        System.out.println("Final bogie states:");
        System.out.println(cylindrical);
        System.out.println(rectangular);

        System.out.println("\nUC15 runtime handling completed...");
    }
}
