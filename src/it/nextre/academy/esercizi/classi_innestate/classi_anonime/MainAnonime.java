package it.nextre.academy.esercizi.classi_innestate.classi_anonime;

import java.time.LocalDate;

public class MainAnonime {

    private int t;
    private StringBuilder builder;

    public MainAnonime(int t, StringBuilder builder) {
        this.t = t;
        this.builder = builder;
    }

    public MainAnonime(MainAnonime mainAnonime) {
        this.t = mainAnonime.getT();
        this.builder = new StringBuilder(mainAnonime.getBuilder());
    }

    public int getT() {
        return t;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public static void main(String[] args) {

        /*Dado d = new Dado(34) {
            private int j = 6;

            @Override
            public void faiQualcosa() {
                System.out.println("sto facendo qualcosa "+j);
            }

            @Override
            public void lancia() {
                System.out.println(new Random().nextInt());
            }
        };
        d.lancia();*/

        /*Dado d2 = new Dado() {
            @Override
            public void lancia() {
                System.out.println(5);
            }
        };
        d2.lancia();*/

        /*IDado iDado12 = () -> System.out.println(new Random().nextInt(12)+1);
        //iDado12.lancia();

        Supplier<String> supplier = () -> "pippo";
        Function<String,Integer> function = s-> s.length();
        Predicate<Integer> predicate = (i)->i > 5;*/

        /*System.out.println(predicate.test(function.apply(supplier.get())));*/


        /*Function<IDado,Integer> f = dado->dado.conta();
        List<IDado> dadoList = new ArrayList<>();
        dadoList.add(iDado12);
        dadoList.add(iDado12);
        dadoList.add(iDado12);
        dadoList.add(iDado12);
        Stream<Integer> stream = dadoList.stream().map(f);
        Optional<Integer> jj = stream.max(Comparator.comparing(Integer::intValue));

        System.out.println(jj.orElseGet(() -> function.apply(supplier.get())));*/


        MainAnonime m = new MainAnonime(1000, new StringBuilder("Gesu"));
        System.out.println(m.getT());
        System.out.println(m.getBuilder().toString());
        try {
            MainAnonime m2 = m.clone();
            System.out.println(m2.getT());
            m2.getBuilder().append("Bau");
            System.out.println(m.getBuilder().toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }//end main

    @Override
    protected MainAnonime clone() throws CloneNotSupportedException {
        return new MainAnonime(this.t, new StringBuilder(this.builder));
    }
}//end class

class g{
    public Number conta(Number n){
        System.out.println(n.toString());
        return n;
    }
}
class p extends g{
    @Override
    public Integer conta(Number n) {
        System.out.println(n.intValue());
        return n.intValue();
    }
}