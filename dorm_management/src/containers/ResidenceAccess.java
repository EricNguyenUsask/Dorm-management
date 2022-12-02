package containers;


import entities.Residence;

public class ResidenceAccess {
    private static Residence instance = null;

    private ResidenceAccess() {
    }

    public static Residence getInstance() {
        if (instance == null)
            throw new IllegalStateException("Singleton residence accessed before initialization");
        return instance;
    }

    public static void initialize(String name, int minBedLabel, int maxBedLabel) {
        if (instance != null) {
            throw new IllegalStateException("Not allowed to reinitialize the residence");
        }
        instance = new Residence(name, minBedLabel, maxBedLabel);
    }
}
