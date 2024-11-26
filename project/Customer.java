package project;

import java.util.ArrayList;
import java.util.List;

public class Customer {
   private final String name;
   private final List<Rental> rentals; // Lista de aluguéis

   public Customer(String name) {
      this.name = name;
      this.rentals = new ArrayList<>();
   }

   public void addRental(Rental rental) {
      rentals.add(rental);
   }

   public String getName() {
      return name;
   }

   public String statement() {
      StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
      for (Rental rental : rentals) {
         // Adiciona detalhes do aluguel
         result.append("\t")
                 .append(rental.getMovie().getTitle())
                 .append("\t")
                 .append(rental.getCharge())
                 .append("\n");
      }

      // Adiciona o rodapé
      result.append("Amount owed is ")
              .append(getTotalCharge())
              .append("\nYou earned ")
              .append(getTotalFrequentRenterPoints())
              .append(" frequent renter points");

      return result.toString();
   }

   /**
    * Gera o relatório de locação em formato HTML.
    */
   public String htmlStatement() {
      StringBuilder result = new StringBuilder("<H1>Rentals for <EM>")
              .append(getName())
              .append("</EM></H1><P>\n");

      for (Rental rental : rentals) {
         // Adiciona detalhes do aluguel em formato HTML
         result.append(rental.getMovie().getTitle())
                 .append(": ")
                 .append(rental.getCharge())
                 .append("<BR>\n");
      }

      // Adiciona o rodapé em formato HTML
      result.append("<P>You owe <EM>")
              .append(getTotalCharge())
              .append("</EM><P>\nOn this rental you earned <EM>")
              .append(getTotalFrequentRenterPoints())
              .append("</EM> frequent renter points<P>");

      return result.toString();
   }

   private double getTotalCharge() {
      return rentals.stream().mapToDouble(Rental::getCharge).sum();
   }

   private int getTotalFrequentRenterPoints() {
      return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
   }
}
