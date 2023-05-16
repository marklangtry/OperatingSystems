

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket on a specific port
            ServerSocket serverSocket = new ServerSocket(8888);
            ExecutorService threadPool = Executors.newFixedThreadPool(5);
            Queue<String> queue = new LinkedList<>();
            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                // Submit the client connection to the thread pool for handling
                threadPool.submit(new ClientHandler(clientSocket,queue));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

