package it.nextre.academy.esercizi.es_DB;

import java.util.Set;

public class Azienda {

    private String name;
    private Double fatturato;
    private Boolean inAttivita;
    //private Set<Dipendente> dipendenti;

    public Azienda(String name, Double fatturato /*Set<Dipendente> dipendenti*/) {
        this.name = name;
        this.fatturato = fatturato;
        this.inAttivita = true;
        //this.dipendenti = dipendenti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFatturato() {
        return fatturato;
    }

    public void setFatturato(Double fatturato) {
        this.fatturato = fatturato;
    }

    public Boolean getInAttivita() {
        return inAttivita;
    }

    public String getInAttivitaForDB() {
        return inAttivita ? "T" : "F";
    }

    public void setInAttivita(Boolean inAttivita) {
        this.inAttivita = inAttivita;
    }

    /*public Set<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(Set<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public void addDipendenti(Dipendente dipendente){
        this.dipendenti.add(dipendente);
    }*/
}//end class
