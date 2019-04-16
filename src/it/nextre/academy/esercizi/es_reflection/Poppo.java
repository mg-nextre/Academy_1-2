package it.nextre.academy.esercizi.es_reflection;

import java.util.Objects;

public class Poppo {

    private String nome;
    private int eta;

    public Poppo(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
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

    public void getQ(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poppo poppo = (Poppo) o;
        return getEta() == poppo.getEta() &&
                Objects.equals(getNome(), poppo.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getEta());
    }
}//end class
