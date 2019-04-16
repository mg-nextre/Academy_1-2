package it.nextre.academy.esercizi.ereditarieta;

public abstract class Auto extends Veicolo{

    public Auto(){
        this(4);
    }
    public Auto(int nRuote){
        this(nRuote, "220cv");
    }
    public Auto(int nRuote, String motore){
        this(nRuote, motore, true);
    }
    public Auto(int nRuote, String motore, boolean volante){
        this(nRuote, motore, volante, "Diesel");
    }
    public Auto(int nRuote, String motore, boolean volante, String carburante){
        this.nRuote = nRuote;
        this.motore = motore;
        this.volante = volante;
        this.carburante = carburante;
    }

    private int nRuote;
    private String motore;
    private boolean volante;
    private String carburante;

    public void sterza(){
            System.out.println("Auto: Sto sterzando");
    }

    public int getnRuote() {
        return nRuote;
    }
    public void setnRuote(int nRuote) {
        this.nRuote = nRuote;
    }
    public String getMotore() {
        return motore;
    }
    public void setMotore(String motore) {
        this.motore = motore;
    }
    public boolean isVolante() {
        return volante;
    }
    public void setVolante(boolean volante) {
        this.volante = volante;
    }
    public String getCarburante() {
        return carburante;
    }
    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

}//end class
