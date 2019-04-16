package it.nextre.academy.esercizi.es_reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MainReflection {

    public static void main(String[] args) {
        try {
            Poppo poppo = new Poppo("pippo",99);
            System.out.println(Caller.qualcosa(poppo.getClass(),poppo));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("Finito");
    }//end main
}//end class
