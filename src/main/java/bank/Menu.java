// paket: bank
// Paket u Javi je mehanizam za enkapsulaciju grupe klasa, podpaketa i interfejsa.
package bank;

// Import klasa
import java.util.Scanner;
import javax.security.auth.login.LoginException;

// Import iznimki
import bank.exceptions.AmountDepositException;
import bank.exceptions.AmountWithdrawException;

// Klasa za prikaz menija
public class Menu {

  // Privatni atribut za skener
  private Scanner scanner;

  // main metoda, početna metoda programa
  public static void main(String[] args) {
    System.out.println("Dobrodosli na Fakultetsku banku!");

    // Kreiranje objekta klase Menu
    Menu menu = new Menu();
    // Kreiranje objekta klase Scanner
    menu.scanner = new Scanner(System.in);

    // Poziv metode za autenticiranje korisnika
    Customer customer = menu.authenticateUser();

    // Provjera da li je korisnik autenticiran
    if (customer != null) {
      // Dohvaćanje računa korisnika
      // Kreiranje objekta klase Account
      // Poziv metode za dohvaćanje računa
      // Metoda vraća račun korisnika
      // Metoda prima ID računa
      // Metoda dohvaća račun iz baze podataka
      // Metoda vraća račun
      Account account = DataSource.getAccount(customer.getAccountId());

      // Poziv metode za prikaz menija
      // Metoda prima korisnika i račun
      // Metoda prikazuje meni
      // Metoda prima unos od korisnika
      // Metoda poziva metode za izvršavanje odabrane opcije
      // Metoda vraća izvršenu opciju
      // Metoda vraća iznimku ako je unos neispravan
      // Metoda vraća iznimku ako je korisnik odjavljen
      menu.showMenu(customer, account);
    }

    // Zatvaranje skenera
    // Poziv metode za zatvaranje skenera
    // Metoda zatvara skener
    menu.scanner.close();
  }

  // Metoda za prijavu korisnika
  private Customer authenticateUser() {

    System.out.println("Unesite korisnicko ime");
    // Dohvaćanje korisničkog imena
    String username = scanner.next();

    System.out.println("Unesite lozinku");
    // Dohvaćanje lozinke
    String password = scanner.next();

    // Kreiranje objekta klase Customer
    // Setovanje Korisnika na null
    Customer customer = null;
    try {
      // Poziv metode za prijavu korisnika
      // Metoda prima korisničko ime i lozinku
      // Metoda vraća korisnika ako je autenticiran
      // Metoda baca iznimku ako korisnik nije pronađen ili je lozinka netočna
      customer = Authenticator.login(username, password);

    } catch (LoginException e) {
      // Ispis poruke o grešci
      System.out.println("Desila se greska: " + e.getMessage());
    }

    // Vraćanje korisnika
    return customer;
  }

  // Metoda za prikaz menija
  // Metoda prima korisnika i račun
  private void showMenu(Customer customer, Account account) {

    // Inicijalizacija varijable za odabir opcije
    int selection = 0;

    // Ispis poruke
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("Dobrodosli " + customer.getName() + "!"); // Dobrodošao korisniče, ime i prezime!

    // Prikaz menija dok korisnik nije odjavljen i dok je odabir opcije različit od 4
    while (selection != 4 && customer.isAuthenticated()) {
      System.out.println("************************************************************");
      System.out.println(" ");
      System.out.println("============================================================");
      System.out.println("Molimo odaberite jednu od opcija, unesite broj za uslugu:");
      System.out.println("1: Uplata novca");
      System.out.println("2: Isplata novca");
      System.out.println("3: Provjera stanja racuna");
      System.out.println("4: Izlaz iz aplikacije");
      System.out.println("============================================================");

      // Dohvaćanje odabira opcije
      selection = scanner.nextInt();
      // Inicijalizacija varijable za iznos
      double amount = 0;

      // Odabir opcije
      switch (selection) {
        // Uplata novca
        case 1:
          System.out.println("Koliko novca zelite uplatiti?");
          // Dohvaćanje iznosa
          amount = scanner.nextDouble();
          try {
            // Poziv metode za uplatu novca
            // Metoda prima iznos
            account.deposit(amount);
          } catch (AmountDepositException e) {
            // Ispis poruke o grešci
            System.out.println(e.getMessage());
            System.out.println("Molimo pokusajte ponovo.");
          }
          break;

        // Isplata novca
        case 2:
          System.out.println("Koliko novca zelite isplatiti?");
          // Dohvaćanje iznosa
          amount = scanner.nextDouble();
          try {
            // Poziv metode za isplatu novca
            // Metoda prima iznos
            account.withdraw(amount);
          } catch (AmountWithdrawException e) {
            // Ispis poruke o grešci
            System.out.println(e.getMessage());
            System.out.println("Molimo pokusajte ponovo.");
          }
          break;

        // Provjera stanja računa
        case 3:
          // Ispis stanja računa
          System.out.println("Trenutno stanje: " + account.getBalance());
          break;

        // Odjava korisnika
        case 4:
          // Poziv metode za odjavu korisnika
          Authenticator.logout(customer);
          // Ispis poruke
          System.out.println("Hvala sto ste koristili Fakultetsku banku!");
          break;

        // Pogrešan unos
        default:
          // Ispis poruke
          System.out.println("Pogresana opcija. Molimo pokusajte ponovo.");
          break;
      }
    }
  }
}