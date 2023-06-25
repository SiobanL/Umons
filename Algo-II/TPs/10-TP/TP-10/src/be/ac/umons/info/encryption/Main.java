package be.ac.umons.info.encryption;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try(ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{114,111,102,108,99,111,112,116,101,114});
            FileOutputStream output = new FileOutputStream("output.txt"))
        {
            //XOREncoding.encode(input, output, (byte)2);
            XOREncoding.encode(input, output, new char[]{115, 111, 105, 115, 111,105,115,111,105,115});
        }catch (IOException e) {
            System.err.printf("%s", e);
        }
    }
}
