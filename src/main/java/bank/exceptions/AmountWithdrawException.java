// Paket: bank.exceptions
// Paket u Javi je mehanizam za enkapsulaciju grupe klasa, podpaketa i interfejsa.
package bank.exceptions;

// Klasa za iznimku AmountWithdrawException
public class AmountWithdrawException extends Exception {

  // Konstruktor za iznimku AmountWithdrawException
  public AmountWithdrawException(String message) {
    // Poziv konstruktora nadklase
    super(message);
  }
}