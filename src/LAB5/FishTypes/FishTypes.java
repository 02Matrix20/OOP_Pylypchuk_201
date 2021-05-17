package LAB5.FishTypes;

public enum FishTypes{
    Pike(1),
    Zander(2);

    private final int fishTypeId;
    FishTypes(int fishTypeId) {
        this.fishTypeId = fishTypeId;
    }

    public int getFishTypeId() {
        return fishTypeId;
    }
}
