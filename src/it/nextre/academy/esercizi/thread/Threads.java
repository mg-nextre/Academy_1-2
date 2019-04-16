package it.nextre.academy.esercizi.thread;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Threads {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*Thread t = new Thread(new CalcolaInNuovoThread("Pippo"));
        t.start();
        t.setPriority(10);

        Thread tt = new Thread(new CalcolaInNuovoThread("Gambadilegno"));
        tt.start();
        tt.setPriority(1);

        System.out.println("Fine main");*/
        /*String parola = "Mietitrebbia";
        String frase = "Meglio un Giacomo oggi che un Paolo domani";

        CalcolaInNuovoThread pippo = new CalcolaInNuovoThread("Pippo", parola, frase);
        CalcolaInNuovoThread gambaDiLegno = new CalcolaInNuovoThread("Gambadilegno",parola, frase);

        Thread tPippo = new Thread(pippo);
        Thread tGamba = new Thread(gambaDiLegno);

        ThreadPoolExecutor tpe = new ScheduledThreadPoolExecutor(3);
        tpe.submit(tPippo);
        tpe.submit(tGamba);*/

        /*ForkJoinPool fjp = new ForkJoinPool();
        //fjp.submit(new CallableClass());
        //fjp.invoke(new CallableClass());
        //System.out.println(fjp.toString());
        //fjp.awaitTermination(10, TimeUnit.SECONDS);
        List<CallableClass> call = new ArrayList<CallableClass>();
        call.add(new CallableClass());
        System.out.println(fjp.invokeAll(call).get(0).get());*/
    }//end main

}//end class
