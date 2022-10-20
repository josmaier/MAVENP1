package gdrn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGameServer {
    
    public static String readInput(InputStream inputStream) throws IOException{
        String serverString = "";
        int b;
        while((b = inputStream.read()) != -1){
            serverString += (char) b;
        }
        return serverString;
    }

    public static void output(OutputStream outputStream, String string) throws IOException{
        outputStream.write((string).getBytes());
    }

    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Waiting for connection...");

            Socket soc = serverSocket.accept();
            InputStream inputStream = soc.getInputStream();
            OutputStream outputStream = soc.getOutputStream();

            int number = ThreadLocalRandom.current().nextInt(50);
            output(outputStream, "Welcome to the number guessing game, type in your first guess");
            int guess = Integer.parseInt(readInput(inputStream));
            int check = 0;
            for(int i = 0; i < 6; i++){
                if(guess == number){
                    output(outputStream, "Congratulations, you guessed the number");
                    check = 1;
                    break;
                } else if(guess < number){
                    output(outputStream, "Your guess is too low!");
                    guess = Integer.parseInt(readInput(inputStream));
                } else {
                    output(outputStream, "Your guess is too high!");
                    guess = Integer.parseInt(readInput(inputStream));
                }
            }
            if (check != 1){
                output(outputStream, "Better Luck next time");
            }







            soc.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
