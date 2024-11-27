package project;

public class HtmlStatement extends Statement {

    @Override
    public String value(Customer aCustomer) {

        String header = "<H1>Rentals for <EM>";
        String footer = "<P>You owe <EM>";


        return prepareStatement(aCustomer, header, footer);
    }


    @Override
    protected String formatRentalDetails(Rental each) {
        return each.getMovie().getTitle() + ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
    }
}
