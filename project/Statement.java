package project;

import java.util.Enumeration;

public abstract class Statement {

    public String statement(Customer aCustomer) {
        return value(aCustomer);
    }

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = createHeader(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += formatRentalDetails(each);
        }
        result += createFooter(aCustomer);
        return result;
    }

    protected abstract String createHeader(Customer aCustomer);

    protected abstract String createFooter(Customer aCustomer);

    protected String formatRentalDetails(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }
}
