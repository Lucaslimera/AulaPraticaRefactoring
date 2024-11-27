package project;

import java.util.Enumeration;

public abstract class Statement {


    public String statement(Customer aCustomer) {
        return value(aCustomer);
    }

    public abstract String value(Customer aCustomer);
    protected String prepareStatement(Customer aCustomer, String header, String footer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = header + aCustomer.getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += formatRentalDetails(each);
        }

        result += footer + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    protected String formatRentalDetails(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }
}
