// Paket bank
// Paket u Javi je mehanizam za enkapsulaciju grupe klasa, podpaketa i interfejsa
package bank;

// Klasa Customer predstavlja korisnika
public class Customer {

  // Atributi klase Customer
  // Id korisnika
  private int id;
  // Ime korisnika
  private String name;
  // Korisničko ime
  private String username;
  // Lozinka
  private String password;
  // Id računa
  private int accountId;
  // Autenticiranost korisnika
  private boolean authenticated;

  // Konstruktor za korisnika
  // Korisnik je inicijalno neautenticiran
  // Korisnik se autenticira prilikom prijave
  // Korisnik se odjavljuje prilikom odjave
  // Korisnik se može odjaviti samo ako je prijavljen
  // Korisnik se može prijaviti samo ako je unesen ispravno korisničko ime i lozinka
  
  public Customer(int id, String name, String username, String password, int accountId) {
    // Postavljanje atributa
    // Poziv metoda za postavljanje atributa

    // Postavljanje id-a korisnika
    setId(id);
    // Postavljanje imena korisnika
    setName(name);
    // Postavljanje korisničkog imena
    setUsername(username);
    // Postavljanje lozinke
    setPassword(password);
    // Postavljanje id-a računa
    setAccountId(accountId);
    // Postavljanje autentikacije korisnika
    setAuthenticated(false);
  }

  // Metoda za ispis korisnika
  public int getId() {
    // Vraćanje id-a korisnika
    return this.id;
  }

  // Metoda za postavljanje id-a korisnika
  public void setId(int id) {
    // Postavljanje id-a korisnika
    this.id = id;
  }

  // Metoda za dohvaćanje imena korisnika
  public String getName() {
    // Vraćanje imena korisnika
    return this.name;
  }

  // Metoda za postavljanje imena korisnika
  public void setName(String name) {
    // Postavljanje imena korisnika
    this.name = name;
  }

  // Metoda za dohvaćanje korisničkog imena
  public String getUsername() {
    // Vraćanje korisničkog imena
    return this.username;
  }

  // Metoda za postavljanje korisničkog imena
  public void setUsername(String username) {
    // Postavljanje korisničkog imena
    this.username = username;
  }

  // Metoda za dohvaćanje lozinke
  public String getPassword() {
    // Vraćanje lozinke
    return this.password;
  }

  // Metoda za postavljanje lozinke
  public void setPassword(String password) {
    // Postavljanje lozinke
    this.password = password;
  }

  // Metoda za dohvaćanje id-a računa
  public int getAccountId() {
    // Vraćanje id-a računa
    return this.accountId;
  }

  // Metoda za postavljanje id-a računa
  public void setAccountId(int accountId) {
    // Postavljanje id-a računa
    this.accountId = accountId;
  }

  // Metoda za provjeru autentikacije korisnika
  public boolean isAuthenticated() {
    // Vraćanje autentikacije korisnika
    return this.authenticated;
  }

  // Metoda za postavljanje autentikacije korisnika
  public void setAuthenticated(boolean authenticated) {
    // Postavljanje autentikacije korisnika
    this.authenticated = authenticated;
  }

}