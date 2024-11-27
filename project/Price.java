package project;

public abstract class Price {

    public abstract double getCharge(int daysRented);

    public abstract int getPriceCode();

    public abstract int getFrequentRenterPoints(int daysRented);
}
