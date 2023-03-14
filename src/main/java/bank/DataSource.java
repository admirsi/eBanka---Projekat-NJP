// Paket: bank
// Paket u Javi je mehanizam za enkapsulaciju grupe klasa, podpaketa i interfejsa
package bank;

// Import klasa
// Import klasa u Javi je mehanizam za uvoz klasa iz drugih paketa
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Klasa za rad s bazom podataka
public class DataSource {

  // Metoda za spajanje na bazu podataka
  public static Connection connect() {

    // Putanja do baze podataka
    String db_file = "jdbc:sqlite:resources/bank.db";
    // Spajanje na bazu podataka
    Connection connection = null;

    // Pokušaj spajanja na bazu podataka
    try {
      // Učitavanje drajvera za bazu podataka
      connection = DriverManager.getConnection(db_file);

    } catch (SQLException e) {
      // Ispis poruke o grešci
      e.printStackTrace();
    }

    // Vraćanje veze s bazom podataka
    return connection;
  }

  // Metoda za dohvaćanje korisnika iz baze podataka
  public static Customer getCustomer(String username) {
    // SQL naredba za dohvaćanje korisnika
    String sql = "select * from customers where username = ?";
    // Korisnik se postavlja na null vrijednost prije dohvaćanja iz baze podataka
    Customer customer = null;

    // Pokušaj dohvaćanja korisnika iz baze podataka
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {

      // Postavljanje parametara SQL naredbe
      // Parametar 1 je korisničko ime
      statement.setString(1, username);
      // Izvršavanje SQL naredbe
      // ResultSet je rezultat SQL naredbe
      // ResultSet sadrži podatke iz baze podataka

      // Pokušaj dohvaćanja rezultata SQL naredbe
      try (ResultSet resultSet = statement.executeQuery()) {
        // Kreiranje korisnika
        customer = new Customer(
            // Dohvaćanje vrijednosti iz rezultata SQL naredbe
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("account_id"));
      }

      // Ako dođe do greške prilikom dohvaćanja korisnika iz baze podataka
    } catch (SQLException e) {
      // Ispis poruke o grešci
      e.printStackTrace();
    }

    // Vraćanje korisnika
    return customer;
  }

  // Metoda za dohvaćanje računa iz baze podataka
  public static Account getAccount(int accountId) {

    // SQL naredba za dohvaćanje računa
    String sql = "select * from accounts where id = ?";

    // Račun se postavlja na null vrijednost prije dohvaćanja iz baze podataka
    Account account = null;

    // Pokušaj dohvaćanja računa iz baze podataka
    try (
        // Spajanje na bazu podataka
        Connection connection = connect();

        // Kreiranje SQL naredbe
        PreparedStatement statement = connection.prepareStatement(sql)) {

      // Postavljanje parametara SQL naredbe
      // Parametar 1 je ID računa koji se dohvaća
      statement.setInt(1, accountId);

      // Izvršavanje SQL naredbe
      // ResultSet je rezultat SQL naredbe
      // ResultSet sadrži podatke iz baze podataka
      // Pokušaj dohvaćanja rezultata SQL naredbe
      try (ResultSet resultSet = statement.executeQuery()) {
        // Kreiranje računa
        account = new Account(
            // Dohvaćanje vrijednosti iz rezultata SQL naredbe
            resultSet.getInt("id"),
            resultSet.getString("type"),
            resultSet.getDouble("balance"));
      }
      // Ako dođe do greške prilikom dohvaćanja računa iz baze podataka
    } catch (SQLException e) {
      // Ispis poruke o grešci
      e.printStackTrace();
    }

    // Vraćanje računa
    return account;
  }

  // Metoda za dohvaćanje računa iz baze podataka
  public static void updateAccountBalance(int accountId, double balance) {

    // SQL naredba za dohvaćanje računa
    String sql = "update accounts set balance = ? where id = ?";
    // Pokušaj dohvaćanja računa iz baze podataka
    try (
        // Spajanje na bazu podataka
        Connection connection = connect();
        // Kreiranje SQL naredbe
        PreparedStatement statement = connection.prepareStatement(sql);) {

      // Postavljanje parametara SQL naredbe
      // Parametar 1 je novo stanje računa
      // Parametar 2 je ID računa koji se updatea
      statement.setDouble(1, balance);
      statement.setInt(2, accountId);

      // Izvršavanje SQL naredbe
      statement.executeUpdate();

      // Ako dođe do greške prilikom dohvaćanja računa iz baze podataka
    } catch (SQLException e) {
      // Ispis poruke o grešci
      e.printStackTrace();
    }
  }
}