package it.nextre.academy.esercizi.collections;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Collections {

    public static void main(String[] args) {

        /*List list = new ArrayList<>();
        list.add("primo elemento");
        list.add(13);
        list.add(true);
        list.add(new Object());

        Object p = list.get(0);

        if(p instanceof String){
            System.out.println(((String) p).length());
        }*/

        /*List<String> listaStringhe = new ArrayList<>();

        listaStringhe.add("gambadilegno");
        listaStringhe.add("gambadilegno");
        listaStringhe.add("gambadilegno");

        System.out.println(listaStringhe);

        Set<String> setStringhe = new HashSet<>();

        setStringhe.add("pippo");
        setStringhe.add("pluto");
        setStringhe.add("pippo");

        System.out.println(setStringhe.toString());*/

        /*Map<Integer, String> myMap = new HashMap<>();

        myMap.put(100, "Paolo assente");
        myMap.put(101, "Nextre");
        myMap.put(102, "Cose a caso");
        myMap.put(102, "Stadio");

        System.out.println(myMap.keySet());
        System.out.println(myMap.values());*/

        /*List<Map<Double, String>> listMap = new ArrayList<>();
        listMap.add(new HashMap<>());

        listMap.get(0).put(0.5,"Lavatrice");*/

        /*System.out.println(listMap.get(0));

        Map<Map<Integer, Object>, List<Double>> pippo = new HashMap<>();*/

        /*System.out.println(Arrays.toString(listMap.toArray()));*/

        /*Date data = new Date();
        Calendar calendario = new GregorianCalendar();*/

        /*LocalDateTime localNow = LocalDateTime.now();
        LocalDate localDate = LocalDate.parse("0000-01-10");


        System.out.println(localDate);*/

        /*LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2010, 12,15);
        //System.out.println(localDate);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-M-dd")));

        System.out.println(Period.between(now,localDate));

        LocalTime nowTime = LocalTime.now();
        LocalTime localTime = LocalTime.of(12,44,23);

        System.out.println(Duration.between(nowTime,localTime));

        System.out.println(LocalTime.now());*/

    }//end main

}//end class
