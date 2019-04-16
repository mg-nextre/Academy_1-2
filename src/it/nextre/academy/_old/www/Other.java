package it.nextre.academy._old.www;

//import it.nextre.academy._old.Es.PukemonMain;

public class Other {

    int numBaseDieci = 300;
    int numBaseDue = 0B01010110;
    int numBaseOtto = 0154273;
    int numBaseSedici = 0x1353AF;

    static byte bit = 120;//MAX: 127

    void metodo(){
        bit = (byte)(bit*2);
        System.out.println(bit);
    }

    public static void main(String[] args) {
        bit = (byte)(bit*2);
        System.out.println(bit);
    }

}//end class
