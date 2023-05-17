package be.ac.umons.info.textfile;

import java.io.*;

public class ToUpper {
    public static void main(String[] args) throws FileNotFoundException {
        String[] path = new String[2];
        path[0] = "scottish_parliament_official_reports.txt";
        path[1] = "Output.txt";
        try(InputStream input = new FileInputStream(path[0]);
            FileOutputStream output = new FileOutputStream(path[1])){
            int b=0;
            while(b >= 0){
                b = input.read();
                output.write(b+32);
            }
        }catch (IOException e){
            System.err.printf("%s", e);

        }
    }
}
