package it.nextre.academy.esercizi.thread;

public class CalcolaInNuovoThread implements Runnable {

    private String nome;
    private Object o1;
    private Object o2;

    public CalcolaInNuovoThread(String nome, Object o1, Object o2){
        this.nome = nome;
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        pippo(o1,o2);
    }//end run

    public void pippo(Object obj1, Object obj2){
        System.out.println(nome);
        synchronized (obj1){
            System.out.println(nome + " Synch on " + obj1.toString());
            synchronized (obj2){
                System.out.println(nome + " Synch on " + obj2.toString());
                try {
                    Thread.sleep(10_000_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//end synch 2
        }//end synch 1
    }//end method

}//end class
