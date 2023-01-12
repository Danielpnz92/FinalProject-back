package FinalProject.FinalProject.model.enums;

public enum PrimeCategories {
    NONE(0),
    BRONZE(5),
    SILVER(10),
    GOLD(20);

    private final int points;

    PrimeCategories(int points) {
        this.points = points;
    }
}
