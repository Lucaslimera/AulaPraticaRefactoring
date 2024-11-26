package project;

public class Movie {

    public enum PriceCode {
        CHILDRENS,
        REGULAR,
        NEW_RELEASE
    }

    private final String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return switch (priceCode) {
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
        };
    }
    public int calculateFrequentRenterPoints(int daysRented) {
        return (priceCode == PriceCode.NEW_RELEASE && daysRented > 1) ? 2 : 1;
    }
}
