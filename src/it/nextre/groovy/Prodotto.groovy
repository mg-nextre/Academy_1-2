package it.nextre.groovy

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Prodotto {

    enum Tipologia {
        CASA, ELETTRONICA, SALUTE_E_BELLEZZA, INFORMATICA, SICUREZZA, FITNESS
    }

    String nome
    BigDecimal prezzo
    Tipologia tipologia
    BigInteger cashback
    BigInteger sconto

    Prodotto(String nome, BigDecimal prezzo, Tipologia tipologia, BigInteger cashback, BigInteger sconto) {
        this.nome = nome
        this.prezzo = prezzo
        this.tipologia = tipologia
        this.cashback = cashback
        this.sconto = sconto
    }

    BigDecimal calcolaPrezzo(){
        return (prezzo - (prezzo*sconto)/100).round(2)
    }

    BigDecimal calcolaCashback(){
        return ((calcolaPrezzo()*cashback)/100).round(2)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Prodotto prodotto = (Prodotto) o

        if (nome != prodotto.nome) return false

        return true
    }

    int hashCode() {
        return (nome != null ? nome.hashCode() : 0)
    }

    @Override
    public String toString() {
        return "Prodotto: " +
                nome +
                ", " + prezzo +
                "€, reparto: " + tipologia +
                ", CB: " + cashback +
                "%, sconto:" + sconto +
                '%| '
    }
}//end groovy class
