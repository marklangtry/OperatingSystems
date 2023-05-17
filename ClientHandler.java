

import java.io.*;
import java.net.*;
import java.util.LinkedList;
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
                    // for (String str : queue) {
                    //     writer.println(str);
                    // }
                    writer.println(queue);
                } 
                else if (dataFromClient.equalsIgnoreCase("average")) {
                    // Gets the average number of characters in a message
                    int totalLength = getCount(queue);
                    int avgLength = totalLength/(queue.size());
                    writer.println(avgLength);
                } 
                else if (dataFromClient.equalsIgnoreCase("count")) {
                    // Gets the total number of messages
                    writer.println(queue.size());
                }
                else if (dataFromClient.equalsIgnoreCase("characters")) {
                    // Gets the total number of characters in a message
                    int totalLength = getCount(queue);
                    writer.println(totalLength);
                } 
                else if(dataFromClient.equalsIgnoreCase("translate")){
                    // Translated the messages into Pig Latin and returns the translated queue
                    Queue<String> translatedMessage = translate(queue);
                    writer.println(translatedMessage);
                }
                else if(dataFromClient.equalsIgnoreCase("end")){
                    // Ends the client-server communication on the clients side
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
        int totalCharacters = 0;
        for (String str : queue) {
            totalCharacters += str.length();
        }
        return totalCharacters;
    }
    Queue<String> translate(Queue<String> queue){
        Queue<String> translatedQueue = new LinkedList<>();
        for (String str : queue) {
            translatedQueue.add(pigLatin(str));
        }
        return translatedQueue;
    }

    String pigLatin(String word) {
        String newString = "";
        // If a word starts with a vowel add the word "way" at the end of the word
        if (isVowel(word.charAt(0))) {
            return word + "way";
        }

        // If a word starts with a consonant and a vowel, put the first letter of the word at the end of the word and add "ay"
        else if (isVowel(word.charAt(1))) {
            char firstLetter = word.charAt(0);
            firstLetter = Character.toLowerCase(firstLetter);
            for (int i = 1; i <= word.length()-1; i++) {
                newString = newString + word.charAt(i);
            }
            newString = newString + firstLetter + "ay";
            return newString;
        }

        // If a word starts with two consonants move the two consonants to the end of the word and add "ay"
        else{
            char firstLetter = word.charAt(0);
            char secondLetter = word.charAt(1);
            firstLetter = Character.toLowerCase(firstLetter);
            for (int i = 2; i <= word.length()-1; i++) {
                newString = newString + word.charAt(i);
            }
            newString = newString + firstLetter + secondLetter + "ay";
            return newString;
        }
    }


    // Check for vowel
    boolean isVowel(char c) {
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }


}