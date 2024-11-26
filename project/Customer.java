package project;

import java.util.Enumeration;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {
   private String _name;
   private Vector _rentals = new Vector();

   public Customer(String name) {
      _name = name;
   }

   public void addRental(Rental arg) {
      _rentals.addElement(arg);
   }

   public String getName() {
      return _name;
   }

   public String statement() {
      double totalAmount = 0;
      int frequentRenterPoints = 0;
      Enumeration rentals = _rentals.elements();
      StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();

         // add frequent renter points
         frequentRenterPoints++;
         // add bonus for a two day new release rental
         if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                 each.getDaysRented() > 1) frequentRenterPoints++;

         //show figures for this rental
         result.append("\t")
                 .append(each.getMovie().getTitle())
                 .append("\t")
                 .append(each.getCharge())
                 .append("\n");

         totalAmount += each.getCharge();
      }
      //add footer lines
      result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
      result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
      return result.toString();
   }
}