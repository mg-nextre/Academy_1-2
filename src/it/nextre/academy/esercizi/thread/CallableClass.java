package it.nextre.academy.esercizi.thread;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Sono un callable";
    }
}//end class
