import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a socket and connect to the server
            Socket socket = new Socket("SERVER_IP_ADDRESS", 8888);
            
            // Create input and output streams for communication
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
            // Create a BufferedReader to read data from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Create a PrintWriter to send data to the server
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            // Send data to the server
            writer.println("Hello from the client!");
            
            // Read the server's response
            String responseFromServer = reader.readLine();
            System.out.println("Received from server: " + responseFromServer);
            
            // Close the connections
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}