package it.nextre.groovy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Utente {

    String username
    BigDecimal saldo = new BigDecimal(0)
    Map<String, Carrello> carrelli = new HashMap<>()
    List<Prodotto> prodottiAcquistati = new ArrayList<>()

    Utente(String username){
        this.username = username
    }

    boolean creaCarrello(String nomeCarrello){
        return carrelli.put(nomeCarrello, new Carrello()) != null
    }

    void aggiungiAlCarrello(Prodotto prodotto, String nomeCarrello){
        checkCarrello(nomeCarrello) ? carrelli.get(nomeCarrello).prodottoList.add(prodotto) : null
    }

    void acquista(String nomeCarrello){
        println "tentativo di acquisto carrello ${nomeCarrello}"

        if(checkCarrello(nomeCarrello)){
            BigDecimal costoTotale = carrelli.get(nomeCarrello).costoTotale()
            BigDecimal cashbackTotale = carrelli.get(nomeCarrello).cashbackTotale()
            println "il costo totale per l'utente $username col carrello $nomeCarrello è: $costoTotale con cashback di: $cashbackTotale"
            if(saldo >= costoTotale){
                carrelli.get(nomeCarrello).prodottoList.forEach{it->prodottiAcquistati.add(it)}
                scalaSaldo(costoTotale)
                aggiungiSaldo(carrelli.get(nomeCarrello).cashbackTotale())
            }else{
                System.err.println("${username}, non hai soldi puveraz!")
            }
        }
    }

    void eliminaProdottoDalCarrello(Prodotto prodotto, String nomeCarrello){
        checkCarrello(nomeCarrello) ? carrelli.get(nomeCarrello).prodottoList.remove(prodotto) : null
        println "prodotto ${prodotto.getNome()} eliminato dal carrello ${nomeCarrello}"
    }

    void eliminaTuttiIProdottiDalCarrello(String nomeCarrello){
        carrelli.get(nomeCarrello).prodottoList.clear()
        println "carrello ${nomeCarrello} svuotato"
    }

    void eliminaCarrello(String nomeCarrello){
        carrelli.remove(nomeCarrello)
        println "carrello ${nomeCarrello} eliminato"
    }

    void copiaCarrello(String nomeCarrelloDaCopiare, String nuovoCarrello){
        checkCarrello(nomeCarrelloDaCopiare) ? creaCarrello(nuovoCarrello) ? carrelli.get(nuovoCarrello).prodottoList.addAll(carrelli.get(nomeCarrelloDaCopiare).prodottoList) : null : null
    }

    void eliminaTuttiIProdottiAcquistati(){
        prodottiAcquistati.clear()
    }

    void aggiungiSaldo(BigDecimal importo){
        importo > 0 ? saldo += importo : null
        roundSaldo()
    }
    private void scalaSaldo(BigDecimal importo){
        saldo -= importo
        roundSaldo()
    }

    private boolean checkCarrello(String nomeCarrello){
        Carrello carrello = carrelli.get(nomeCarrello)
        if(carrello == null){
            System.err.println("CARRELLO NON PRESENTE")
            return false
        }
        return true
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false
        Utente utente = (Utente) o
        if (username != utente.username) return false
        return true
    }

    int hashCode() {
        return (username != null ? username.hashCode() : 0)
    }

    private void roundSaldo(){
        saldo = saldo.round(2)
    }
}//end groovy class
