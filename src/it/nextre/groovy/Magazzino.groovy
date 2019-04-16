package it.nextre.groovy

class Magazzino {

    static List<String> nomiProdotti = ["mouse","portatile","telecomando","tostapane","telefonino ASUS","phon","cuffie auricolari","cuffie da gaming","orologio","ventilatore a torre","mini ventilatore usb","ventilatore da tavolo","bicchiere in vetro","bicchiere in plastica","zaino"]
    static List<Prodotto.Tipologia> tipologiaProdotti = Prodotto.Tipologia.values()
    static Set<Prodotto> setProdotti = []
    static Random r = new Random()

    static Set<Prodotto> getSetProdotti(){

        for (def i in 1..200000){

            setProdotti.add(
                    new Prodotto(
                            nomiProdotti.get(r.nextInt(nomiProdotti.size())),
                            new BigDecimal(r.nextInt(1000)),
                            tipologiaProdotti.get(r.nextInt(tipologiaProdotti.size())),
                            new BigInteger(r.nextInt(100)),
                            new BigInteger(r.nextInt(100))
                    )
            )

        }//end for
        return setProdotti
    }//end getListaProdotti

}//end groovy class
