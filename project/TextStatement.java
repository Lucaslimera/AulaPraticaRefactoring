package project;

public class TextStatement extends Statement {

    @Override
    protected String createHeader(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    protected String createFooter(Customer aCustomer) {
        return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
                "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }
}
