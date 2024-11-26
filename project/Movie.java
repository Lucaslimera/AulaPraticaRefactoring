package project;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR -> this.price = new RegularPrice();
            case CHILDRENS -> this.price = new ChildrensPrice();
            case NEW_RELEASE -> this.price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Invalid Price Code");
        }
    }

    public double getCharge(int daysRented) {
        return switch (getPriceCode()) {
            case REGULAR -> {
                double amount = 2;
                if (daysRented > 2) amount += (daysRented - 2) * 1.5;
                yield amount;
            }
            case NEW_RELEASE -> daysRented * 3;
            case CHILDRENS -> {
                double amount = 1.5;
                if (daysRented > 3) amount += (daysRented - 3) * 1.5;
                yield amount;
            }
            default -> throw new IllegalStateException("Unexpected value: " + getPriceCode());
        };
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (getPriceCode() == NEW_RELEASE && daysRented > 1) ? 2 : 1;
    }
}