import static org.junit.Assert.assertEquals;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class ClientHandlerTest {
    // ServerSocket serverSocket = new ServerSocket(8888);
    // Queue<String> queue = new LinkedList<>();
    // // Accept incoming client connections
    // Socket clientSocket = serverSocket.accept();
    // // Submit the client connection to the thread pool for handling
    // ClientHandler test = new ClientHandler(clientSocket, queue);

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

    // @Test
    // public void testPigLatin() {
    //     assertEquals("anplay", ClientHandler.pigLatin("plan"));
    // }


    // @Test
    // public void testAddition() {
    //     int result = ClientHandler.add(2, 3);
    //     assertEquals(5, result);
    // }
}




// <dependency>
//     <groupId>org.junit.jupiter</groupId>
//     <artifactId>junit-jupiter-api</artifactId>
//     <version>5.9.1</version>
//     <scope>test</scope>
// </dependency>
// <dependency>
//     <groupId>org.junit.jupiter</groupId>
//     <artifactId>junit-jupiter-engine</artifactId>
//     <version>5.9.1</version>
//     <scope>test</scope>
// </dependency>





// <dependency>
//     <groupId>org.junit.jupiter</groupId>
//     <artifactId>junit-jupiter-api</artifactId>
//     <version>5.9.1</version>
//     <scope>test</scope>
// </dependency>
// <dependency>
//     <groupId>org.junit.jupiter</groupId>
//     <artifactId>junit-jupiter-engine</artifactId>
//     <version>5.9.1</version>
//     <scope>test</scope>
// </dependency>