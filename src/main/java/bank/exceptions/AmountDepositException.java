// Paket: bank.exceptions
// Paket u Javi je mehanizam za enkapsulaciju grupe klasa, podpaketa i interfejsa.
package bank.exceptions;

// Klasa za iznimku AmountWithdrawException
public class AmountDepositException extends Exception {

  // Konstruktor za iznimku AmountWithdrawException
  public AmountDepositException(String message) {
    // Poziv konstruktora nadklase
    super(message);
  }


}