package project;

public class TextStatement extends Statement {

    @Override
    public String value(Customer aCustomer) {

        String header = "Rental Record for ";
        String footer = "Amount owed is ";


        return prepareStatement(aCustomer, header, footer);
    }
}
