

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server
            Socket socket = new Socket("localhost", 8888);
            
            // Create input and output streams for communication
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
            // Create a BufferedReader to read data from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Create a PrintWriter to send data to the server
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            Scanner in = new Scanner(System.in);
            boolean running = true;
            while(running){
                System.out.println("Enter a message: ");
                String ClientInput = in.nextLine();
                writer.println(ClientInput);
                String responseFromServer = reader.readLine();
                if(responseFromServer != null){
                    System.out.println("Received from server: " + responseFromServer);
                }
                else{
                    running = false;
                }
            }
                
                
            
            // Close the connections
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}