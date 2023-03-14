// Package: bank
// Paket u Javi je mehanizam za enkapsulaciju grupe klasa, podpaketa i interfejsa.
package bank;

// Import klasa
import javax.security.auth.login.LoginException;

// Klasa za autenticiranje korisnika
public class Authenticator {

  // Metoda za autenticiranje korisnika
  // Metoda prima korisničko ime i lozinku
  // Metoda vraća korisnika ako je autenticiran
  // Metoda baca iznimku ako korisnik nije pronađen ili je lozinka netočna
  
  // Metoda za prijavu korisnika
  public static Customer login(String username, String password) throws LoginException {

    // Dohvaćanje korisnika iz baze podataka
    Customer customer = DataSource.getCustomer(username);
    // Provjera da li je korisnik pronađen
    if (customer == null) {
      // Ako korisnik nije pronađen, baca se iznimka
      throw new LoginException("Korisnik nije pronađen");
    }

    // Provjera da li je lozinka ispravna
    if (password.equals(customer.getPassword())) {
      // Ako je lozinka ispravna, korisnik je autenticiran
      customer.setAuthenticated(true);
      // Vraćanje korisnika
      return customer;
    }

    // Ako je lozinka netočna, baca se iznimka
    else
      throw new LoginException("Netačna lozinka");
  }

  // Metoda za odjavu korisnika
  public static void logout(Customer customer) {
    // Postavljanje korisnika na neautenticiranog
    customer.setAuthenticated(false);
  }
}