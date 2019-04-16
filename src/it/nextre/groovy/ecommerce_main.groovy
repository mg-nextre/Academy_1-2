package it.nextre.groovy

/*start groovy script*/
ECommerce eCommerce = ECommerce.getInstance()
def prodottiInMagazzino = Magazzino.getSetProdotti()
eCommerce.aggiungiProdottiDisponibili(prodottiInMagazzino)

List<Utente> utenti = new ArrayList<>()
for (def i in 1..30){
    Utente u = new Utente(i+"pippo")
    u.aggiungiSaldo(new BigDecimal(new Random().nextInt(10000)))
    eCommerce.aggiungiUtenti(u)
    eCommerce.aggiungiCarrello(u,"pippo")
    //u.creaCarrello("pippo")
    for(def j in 1..10){
        Prodotto p = eCommerce.prodottiDisponibili.getAt(new Random().nextInt(eCommerce.prodottiDisponibili.size()))
        //u.aggiungiAlCarrello(p,"pippo")
        eCommerce.aggiungiProdottoAlCarrello(u,"pippo",p)
    }
    utenti.add(u)
}
//eCommerce.aggiungiUtenti(utenti)

for(def u in utenti){
    println "-----------------------------------------------------------"
    println "saldo iniziale ${u.getUsername()}: "+u.getSaldo()
    println "num prodotti nel carrello: ${u.getCarrelli().get("pippo").prodottoList.size()}"
    u.acquista("pippo")
    println "num prodotti acquistati: ${u.prodottiAcquistati.size()}"
    println "saldo residuo ${u.getUsername()}: "+u.getSaldo()
    println "-----------------------------------------------------------"
}

/*
utente1.creaCarrello("Giacomo dopo tocca a te!")
utente1.aggiungiAlCarrello(eCommerce.prodottiDisponibili.get(0),"Giacomo dopo tocca a te!")
utente1.aggiungiSaldo(1000.0)
utente1.copiaCarrello("Giacomo dopo tocca a te!", "PaoloCulo")
utente1.eliminaCarrello("PaoloCulo")
utente1.creaCarrello("Cibo")
utente1.aggiungiAlCarrello(eCommerce.prodottiDisponibili.get(100),"Cibo")
utente1.eliminaProdottoDalCarrello(eCommerce.prodottiDisponibili.get(100),"Cibo")
utente1.eliminaTuttiIProdottiDalCarrello("Cibo")

println utente1.getSaldo()
utente1.acquista("Giacomo dopo tocca a te!")
utente1.prodottiAcquistati.stream().forEach{it->println it}
println utente1.getSaldo()
*/
