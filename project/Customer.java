package project;

public class Customer {

   private String _name;
   private Vector _rentals = new Vector();


   public String statement() {
      Statement statement = new TextStatement();
      return statement.statement(this);
   }

   public String htmlStatement() {
      Statement statement = new HtmlStatement();
      return statement.statement(this);
   }

   public Enumeration getRentals() {
      return _rentals.elements();
   }

   public double getTotalCharge() {
      double result = 0;
      Enumeration rentals = _rentals.elements();
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += each.getCharge();
      }
      return result;
   }

   public int getTotalFrequentRenterPoints() {
      int result = 0;
      Enumeration rentals = _rentals.elements();
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += each.getFrequentRenterPoints();
      }
      return result;
   }
}
