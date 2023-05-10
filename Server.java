package ChatServer;


import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket on a specific port
            ServerSocket serverSocket = new ServerSocket(8888);
            
            // Accept incoming client connections
            Socket clientSocket = serverSocket.accept();
            
            // Create input and output streams for communication
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            
            // Create a BufferedReader to read data from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Read data from the client
            String dataFromClient = reader.readLine();
            System.out.println("Received from client: " + dataFromClient);
            
            // Create a PrintWriter to send data to the client
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            // Send a response to the client
            writer.println("Hello from the server!");
            
            // Close the connections
            writer.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

