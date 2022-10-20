package gdrn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static String readInput(InputStream inputStream) throws IOException{
        String serverString = "";
        int b;
        while((b = inputStream.read()) != -1){
            serverString += (char) b;
        }
        return serverString;
    }

    public static void output(OutputStream outputStream, String string) throws IOException{
        outputStream.write((String).getBytes());
    }
    public static void main(String[] args) {
        
        
        try {
            Socket soc = new Socket("127.0.0.1",5555);
            System.out.println("Connection succesful");

            InputStream inputStream = soc.getInputStream();
            OutputStream outputStream = soc.getOutputStream();
            System.out.println(readInput(inputStream));

            
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
    
}
