package OperatingSystems;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams for communication
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Create a BufferedReader to read data from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Create a PrintWriter to send data to the client
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Read data from the client
            String dataFromClient = reader.readLine();
            System.out.println("Received from client: " + dataFromClient);
            MessageQueue queue = new MessageQueue(10);
            if (dataFromClient.equalsIgnoreCase("retrieve")) {
                // Retrieve and send the stored messages to the client
                writer.println(queue.dequeue());
            } 
            else if(dataFromClient.equalsIgnoreCase("translate"){
                String message = queue.dequeue();
                String translatedMessage = message;
                writer.println(translatedMessage);
            }
            else if(dataFromClient.equalsIgnoreCase("end"){
                writer.close();
                reader.close();
                clientSocket.close();
            }
            else {
                // Store the message in the queue
                synchronized (queue) {
                    queue.enqueue(dataFromClient);
                    writer.println("Message received by the server");
                }

                // Send a response to the client
                
            }

            // Close the connections
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}