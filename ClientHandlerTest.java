import static org.junit.Assert.assertEquals;


import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

public class ClientHandlerTest {

    // Testing both the Translate function and the Client and server communicate with each other
    @Test
    public void testPigLatin() {
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
        String testString = "plan";
        writer.println(testString);
        writer.println("translate");
        String translatedResult = reader.readLine();
        assertEquals("[anplay]", translatedResult);
        writer.close();
        reader.close();
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @Test
    public void testIsVowel() {
        assertEquals(true, ClientHandler.isVowel('a'));
        assertEquals(true, ClientHandler.isVowel('A'));
        assertEquals(true, ClientHandler.isVowel('u'));
        assertEquals(false, ClientHandler.isVowel('D'));
        assertEquals(false, ClientHandler.isVowel('d'));
        assertEquals(false, ClientHandler.isVowel('z'));
        assertEquals(false, ClientHandler.isVowel('1'));
    }
}