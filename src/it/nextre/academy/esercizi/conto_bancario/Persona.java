package it.nextre.academy.esercizi.conto_bancario;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Persona {

    private String nome;
    private String cognome;
    private String codiceFiscale;
    private LocalDateTime dataDiNascita;
    private int eta;

    public Persona(){}

    public Persona(String nome, String cognome, String codiceFiscale, LocalDateTime dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataDiNascita = dataDiNascita;
        this.eta = calcolaEta();
    }

    private int calcolaEta(){
        return LocalDateTime.now().minus(this.dataDiNascita.getSecond(), ChronoUnit.SECONDS).getYear();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public LocalDateTime getDataDiNascita() {
        return dataDiNascita;
    }
    public int getEta() {
        return eta;
    }
}//end class
