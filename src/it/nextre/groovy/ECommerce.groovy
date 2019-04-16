package it.nextre.groovy

class ECommerce {

    private static ECommerce instance = null
    private Set<Utente> utenti = null
    private Set<Prodotto> prodottiDisponibili = null
    private ECommerceDAO eCommerceDAO = new ECommerceDAO()

    private ECommerce() {
        this.utenti = new ArrayList<>()
        this.prodottiDisponibili = new ArrayList<>()
    }

    static synchronized ECommerce getInstance(){
        if(instance == null){
            instance = new ECommerce()
        }
        return instance
    }

    void aggiungiUtenti(Utente utente){
        utenti.add(utente)
        ECommerceDAO.insertTabellaUtente(utente)
    }

    void aggiungiUtenti(Set<Utente> utenti){
        this.utenti.addAll(utenti)
        utenti.forEach(ECommerceDAO::insertTabellaUtente)
    }

    void aggiungiCarrello(Utente utente, String nomeCarrello){
        utente.creaCarrello(nomeCarrello)
        ECommerceDAO.insertTabellaCarrello(nomeCarrello,utente)
    }
    void aggiungiProdottoAlCarrello(Utente utente, String nomeCarrello, Prodotto prodotto){
        utente.aggiungiAlCarrello(prodotto,nomeCarrello)
        ECommerceDAO.insertTabellaCarrelloProdotto(utente.username,prodotto.nome,nomeCarrello)
    }

    void aggiungiProdottiDisponibili(Prodotto prodotto){
        prodottiDisponibili.add(prodotto)
        ECommerceDAO.insertTabellaProdotto(prodotto)
    }

    void aggiungiProdottiDisponibili(Set<Prodotto> prodotti){
        prodottiDisponibili.addAll(prodotti)
        prodottiDisponibili.forEach(ECommerceDAO::insertTabellaProdotto)
    }

}//end groovy class
