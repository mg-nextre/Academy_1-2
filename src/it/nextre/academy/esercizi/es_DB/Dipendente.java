package it.nextre.academy.esercizi.es_DB;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Dipendente extends Persona{

    private String iban;
    private String ruolo;
    private String email;
    private LocalDate dataAssunzione;
    private Azienda azienda;

    public Dipendente(String nome, int eta, Persona.Sesso sesso, String iban, String ruolo, String email, LocalDate dataAssunzione, Azienda azienda) {
        super(nome, eta, sesso);
        this.iban = iban;
        this.ruolo = ruolo;
        this.email = email;
        this.dataAssunzione = dataAssunzione;
        this.azienda = azienda;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dipendente that = (Dipendente) o;
        return Objects.equals(getIban(), that.getIban()) &&
                Objects.equals(getRuolo(), that.getRuolo()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getDataAssunzione(), that.getDataAssunzione()) &&
                Objects.equals(getAzienda(), that.getAzienda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIban(), getRuolo(), getEmail(), getDataAssunzione(), getAzienda());
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "iban='" + iban + '\'' +
                ", ruolo='" + ruolo + '\'' +
                ", email='" + email + '\'' +
                ", dataAssunzione=" + dataAssunzione +
                ", azienda=" + azienda +
                '}';
    }
}//end class
