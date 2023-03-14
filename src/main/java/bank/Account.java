// Paket bank
package bank;

// Import iznimki
import bank.exceptions.AmountDepositException;
import bank.exceptions.AmountWithdrawException;

// Klasa Account predstavlja bankovni račun
public class Account {

  // Atributi klase Account
  // Id računa
  private int id;
  // Tip računa
  private String type;
  // Stanje računa
  private double balance;

  // Konstruktor za bankovni račun
  public Account(int id, String type, double balance) {
    // Postavljanje atributa
    // Poziv metoda za postavljanje atributa

    // Postavljanje id-a računa
    setId(id);
    // Postavljanje tipa računa
    setType(type);
    // Postavljanje stanja računa
    setBalance(balance);
  }

  // Metoda za ispis računa
  public int getId() {
    // Vraćanje id-a računa
    return this.id;
  }

  // Metoda za postavljanje id-a računa
  public void setId(int id) {
    // Postavljanje id-a računa
    this.id = id;
  }

  // Metoda za dohvaćanje tipa računa
  public String getType() {
    // Vraćanje tipa računa
    return this.type;
  }

  // Metoda za postavljanje tipa računa
  public void setType(String type) {
    // Postavljanje tipa računa
    this.type = type;
  }

  // Metoda za dohvaćanje stanja računa
  public double getBalance() {
    // Vraćanje stanja računa
    return this.balance;
  }

  // Metoda za postavljanje stanja računa
  public void setBalance(double balance) {
    // Postavljanje stanja računa
    this.balance = balance;
  }

  // Metoda za uplatu novca na račun
  public void deposit(double amount) throws AmountDepositException {

    // Ako je uplata manja od 1KM, baca se iznimka
    if (amount < 1) {
      throw new AmountDepositException("Minimalna uplata je 1.00KM");
    } else {
      // Ako je uplata veća ili jednaka 1KM, račun se ažurira
      double newBalance = balance + amount;
      // Ažuriranje stanja računa
      setBalance(newBalance);
      // Ažuriranje stanja računa u bazi podataka
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  // Metoda za isplatu novca sa računa
  public void withdraw(double amount) throws AmountWithdrawException {

    if (amount <= 0) {
      // Ako je isplata manja ili jednaka 0KM, baca se iznimka
      throw new AmountWithdrawException("Isplata mora biti veca od 0KM.");
    } else if (amount > getBalance()) {
      // Ako je isplata veća od stanja na računu, baca se iznimka
      throw new AmountWithdrawException("Nemate dovoljno sredstava na racunu za ovu isplatu.");
    } else {
      // Ako je isplata veća od 0KM i manja od stanja na računu, račun se ažurira
      double newBalance = balance - amount;
      // Ažuriranje stanja računa
      setBalance(newBalance);
      // Ažuriranje stanja računa u bazi podataka
      DataSource.updateAccountBalance(id, newBalance);
    }
  }
}