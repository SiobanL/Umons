package be.ac.umons.info.encryption;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class XOREncoding {
    static public void encode(InputStream input, OutputStream output, byte base) throws IOException {
        int b;
        do{
            b = input.read();
            output.write(b^base);
        }while(b >= 0);
    }
    static public void decode(InputStream input, OutputStream output, byte base) throws IOException {
        encode(input, output, base);
    }
    static public void encode(InputStream input, OutputStream output, char[] key) throws IOException {
        int b, i = 0;
        do{
            i++;
            b = input.read();
            output.write(b^key[i% key.length]);
        }while(b >= 0);
    }
}
