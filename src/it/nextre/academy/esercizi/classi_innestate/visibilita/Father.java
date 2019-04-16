package it.nextre.academy.esercizi.classi_innestate.visibilita;

import java.util.concurrent.atomic.AtomicInteger;

public class Father {

    //public Father(){}

    public Father(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int a;
    protected int b;
    int c;
    private int d;

    public static void main(String[] args) {
        Father f = new Father(1000,2000,3000,4000);
        Son v = f.new Son();
        //Father.Son s = new Father.Son();
    }//end main

    private class Son extends Father{

        private int allah;
        /*public int a;
        protected int b;
        int c;
        private int d;*/

        private Son(){
            super(1,2,3,4);
            super.a=3;
            b=3;
            c=3;
            d=3;
        }
    }//son1

    private class GrandSon extends Son{

        private GrandSon(){
            //Father.a = 5;
            a = 4;
        }

        public void faiQualcosa(StringBuilder jj, int i, AtomicInteger ai){
            jj.append(54);
            //int ii = i;
            ai.addAndGet(i);
            class pippo{
                private int d = 4;
                public String c = "udshfhfr";

                private void stampa(){
                    System.out.println(c+d+jj+ai);
                }
            }//end class
            new pippo().stampa();
            //jj= new StringBuilder();

        }

    }//son2

}//father
