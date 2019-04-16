package it.nextre.academy.pukemons.logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.Properties;

public class Logger {

    private final LocalDateTime ldt = LocalDateTime.now();
    private final String path = "src/it/nextre/academy/pukemons/logger/logs/"+ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss"))+".log";
    private final File file = new File(path);
    private final FileWriter fw = new FileWriter(file, false);
    private final FileReader fr = new FileReader(file);
    private final BufferedWriter bw = new BufferedWriter(fw);
    private final BufferedReader br = new BufferedReader(fr);

    // private final String s = System.lineSeparator();

    private static Logger logger;

    private Logger() throws IOException {
        deleteOldLogFiles();
    }

    public static synchronized Logger getInstance(){
        if(logger == null){
            try {
                logger = new Logger();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return logger;
    }

    private void deleteOldLogFiles() throws IOException {
        File parentDirectory = new File(file.getParent());
        File[] filesInDirectory = parentDirectory.listFiles();
        if(filesInDirectory != null && filesInDirectory.length > 3){
            List<Instant> instants = new ArrayList<>();
            BasicFileAttributes bfa;
            for(File file : filesInDirectory){
                bfa = Files.readAttributes(file.toPath(),BasicFileAttributes.class);
                instants.add(bfa.creationTime().toInstant());
            }//for
            OptionalLong minInstant = instants.stream().mapToLong(i -> i.toEpochMilli()).min();
            for(File file : filesInDirectory){
                if(minInstant.isPresent() && Files.readAttributes(file.toPath(),BasicFileAttributes.class).creationTime().toInstant().toEpochMilli() == minInstant.getAsLong()){
                    file.delete();
                }//if
            }//for
        }//endif
    }//deleteOldLogFiles

    public String write(String frasi) {
        try {
            bw.write(frasi);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return frasi;
    }

    public List<String> write(List<String> list) throws IOException {
        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i));
        }
        bw.newLine();
        bw.flush();
        return list;
    }

    public String readSingleLine() throws IOException {
        return br.readLine();
    }

    public List<String> readAll() throws IOException {
        String line;
        List<String> contenuto = new ArrayList<>();
        while((line = br.readLine()) != null){
            contenuto.add(line);
        }
        return contenuto;
    }
}//end class
