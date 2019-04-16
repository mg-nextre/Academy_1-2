package it.nextre.academy.esercizi.es_DB;

import java.util.Objects;

public class Persona {

    /*package-private*/
    enum Sesso{
        UOMO, DONNA, ALTRO
    }

    private String nome;
    private int eta;
    private Sesso sesso;

    public Persona(String nome, int eta, Sesso sesso) {
        this.nome = nome;
        this.eta = eta;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return getEta() == persona.getEta() &&
                Objects.equals(getNome(), persona.getNome()) &&
                getSesso() == persona.getSesso();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEta(), getSesso());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", sesso=" + sesso +
                '}';
    }
}//end class
