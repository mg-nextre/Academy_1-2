package it.nextre.academy.esercizi.enums;

public enum Enum1 {
    A("pippo"){
        public void stampa(){
            System.out.println("Paolo");
        }

        @Override
        public void pippo(Integer i) {
            super.pippo(i+24);
        }
    }, B;

    private Enum1(String s){
        //super();
        System.out.println(s);
    }
    private Enum1(){}

    public void pippo(Integer i){
        System.out.println(++i);
    }
    //public static final int ii = 0;

}//end enum
