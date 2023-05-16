

import java.io.*;
import java.net.*;
import java.util.Queue;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Queue<String> queue;
    public ClientHandler(Socket clientSocket,Queue<String> queue) {
        this.clientSocket = clientSocket;
        this.queue = queue;
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
            boolean running = true;
            while(running){
                String dataFromClient = reader.readLine();
                System.out.println("Received from client: " + dataFromClient);
                if (dataFromClient.equalsIgnoreCase("retrieve")) {
                    // Retrieve and send the stored messages to the client
                    writer.println(queue);
                } 
                else if (dataFromClient.equalsIgnoreCase("average")) {
                    // Retrieve and send the stored messages to the client
                    int totalLength = getCount(queue);
                    int avgLength = totalLength/(queue.size());
                    writer.println(avgLength);
                } 
                else if (dataFromClient.equalsIgnoreCase("count")) {
                    // Retrieve and send the stored messages to the client
                    int totalLength = getCount(queue);
                    writer.println(totalLength);
                } 
                else if(dataFromClient.equalsIgnoreCase("translate")){
                    
                    writer.println(queue);
                }
                else if(dataFromClient.equalsIgnoreCase("end")){
                    running = false;
                }
                else {
                    // Store the message in the queue
                    synchronized (queue) {
                        queue.add(dataFromClient);
                        writer.println("Message received by the server");
                    }
                    
                }
            }
            writer.close();
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int getCount(Queue<String> queue){
        Queue<String> copy = queue;
        int count = 0;
        while(copy.size()>0){
            String currentElement = copy.poll();
            count += currentElement.length();
        }
        return count;
    }

}