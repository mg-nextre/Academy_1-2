package it.nextre.academy.esercizi.conto_bancario;

import it.nextre.academy.utilities.banca.UtilityBanca;
import java.time.LocalDateTime;

public class Account extends Persona{

    private String username;
    private int pin;
    private final String IBAN;
    private Double saldo;

    public Account(String nome, String cognome, String codiceFiscale, LocalDateTime dataDiNascita, String username, int pin) {
        super(nome, cognome, codiceFiscale, dataDiNascita);
        this.username = username;
        this.pin = pin;
        this.IBAN = UtilityBanca.generateIBAN();
        this.saldo = 0.0;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public Double getSaldo() {
        return saldo;
    }
    public String getIBAN() {
        return IBAN;
    }

    public void operazione(Double amount, boolean isDeposito,int pin){
        if(this.pin != pin){
            System.err.println("PIN ERRATO");
            return;
        }
        amount = Math.abs(amount);
        this.saldo = isDeposito ? this.saldo+amount : this.saldo-amount;
    }
    public void calcolaInteressi(Double percent){
        this.saldo += this.saldo*percent;
    }

}//end class
