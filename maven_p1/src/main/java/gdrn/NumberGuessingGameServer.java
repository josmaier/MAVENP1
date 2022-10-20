package gdrn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGameServer {
    
    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Waiting for connection...");

            Socket soc = serverSocket.accept();
            InputStream inputStream = soc.getInputStream();
            OutputStream outputStream = soc.getOutputStream();

            int number = ThreadLocalRandom.current().nextInt(50);
            outputStream.write(("Welcome to the number guessing game, type in your first guess").getBytes());




            soc.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
