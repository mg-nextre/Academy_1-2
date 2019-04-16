package it.nextre.groovy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Carrello {

    List<Prodotto> prodottoList = new ArrayList<>()

    BigDecimal costoTotale(){
        return BigDecimal.valueOf(prodottoList.stream().mapToDouble{Prodotto p->p.calcolaPrezzo().toDouble()}.sum()).round(2)
    }
    BigDecimal cashbackTotale(){
        return BigDecimal.valueOf(prodottoList.stream().mapToDouble{Prodotto p->p.calcolaCashback().toDouble()}.sum()).round(2)
    }

}//end groovy class
