package it.nextre.academy.esercizi.file_streams;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Window;

import java.io.*;
import java.util.stream.Stream;

public class FileMain {

    public static void main(String[] args) {

        File f = new File("src/it/nextre/academy/esercizi/file_streams/pippo.txt");

        /*try (FileOutputStream fos = new FileOutputStream(f, false); BufferedOutputStream bos = new BufferedOutputStream(fos);  FileInputStream fis = new FileInputStream(f)){
            /*fos.write(new byte[]{'c','\t',1,9,'\n',4,12,111});
            System.out.println("Stampato qualcosa");
            int c = 0;
            while((c = fis.read()) != -1){
                System.out.print((char)c);
            }//end while
            System.out.print("\nLetto qualcosa");

            bos.write(12);*/
        try(FileWriter fw = new FileWriter(f, false); FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){

            /*fw.write("Paolo non arriva mai in orario\n");
            fw.write("Paolo non arriva mai in orario\n");
            fw.write("Paolo non arriva mai in orario\n");
            fw.write("Paolo non arriva mai in orario\n");
            fw.write("Paolo non arriva mai in orario\n");
            fw.write("Paolo non arriva mai in orario\n");

            fw.flush();*/

            /*Stream<String> s = br.lines();
            s.forEach(System.out::println);*/

            /*String c;
            while((c = br.readLine()) != null){
                System.out.println(c);
            }//end while*/

            //System.out.println(br.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }//end main
}//end class
