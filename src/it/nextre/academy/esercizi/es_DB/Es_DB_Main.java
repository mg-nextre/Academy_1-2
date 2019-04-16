package it.nextre.academy.esercizi.es_DB;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Es_DB_Main {

    public static void main(String[] args) {
        try {
            DBDAO dbdao = new DBDAO();

            Set<Azienda> aziende = new HashSet<>();

            Azienda azienda1 = new Azienda("SixthContinent",99999.00);
            Azienda azienda2 = new Azienda("Pippazienda",999999999999999999999999999999.00);
            aziende.add(azienda1);
            aziende.add(azienda2);

            Set<Dipendente> dipendenti = new HashSet<>();
            dipendenti.add(new Dipendente("ciccio",30, Persona.Sesso.UOMO,"sefef","panettiere","dfff@fsf.com",LocalDate.now(),azienda1));
            dipendenti.add(new Dipendente("ciccio",30, Persona.Sesso.DONNA,"sefef","panettiere","dfff@fsf.com",LocalDate.now(),azienda1));
            dipendenti.add(new Dipendente("paolo",999999, Persona.Sesso.ALTRO,"sefef","ghiro","paolo@sveglia.zzz",LocalDate.now(),azienda2));
            dipendenti.add(new Dipendente("giacomo",999999999, Persona.Sesso.ALTRO,"SXC-CARD-50%+CASHBACK(2.5%)","risparmiatore seriale","iscriviti@conilmio.referral",LocalDate.of(0,1,1),azienda2));

            aziende.stream().forEach(a->{
                try {
                    dbdao.saveAzienda(a);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            dipendenti.stream().forEach(d-> {
                try {
                    dbdao.saveDipendente(d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            //JAVA LANG REFLECTION
            Class c = DBConnect.class;
            Arrays.asList(c.getDeclaredFields()).stream().map(f->f.getName()).forEach(System.out::println);
            //Modifier
            Method[] m = c.getDeclaredMethods();
            List<Method> methodList = Arrays.asList(m);
            methodList.sort(Comparator.comparing(Method::getName));
            /*for(Method d : m){
                System.out.println(d);
                d.invoke(new DBConnect());
            }*/
            //Connection x =(Connection) m[0].invoke(new DBConnect());
            List returns = new ArrayList();

            methodList.stream().forEach(j-> {
                try {
                    if(j.getName().equals("dropDB")){
                        return;
                    }
                    returns.add(j.invoke(c));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });

            returns.stream().forEach(System.out::println);

            //dbdao.deleteAzienda(azienda1);
            //dbdao.deleteDipendente((Dipendente) dipendenti.toArray()[1]);
            dbdao.closeConnection();
            System.out.println("Salvataggio finito");

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        } /*catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
    }//end main
}//end class
