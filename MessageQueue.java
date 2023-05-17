
import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private int maxSize;
    private Queue<String> queue = new LinkedList<String>(); 
    public MessageQueue(int size) { 
        this.maxSize = size;
    } 
    public synchronized void enqueue(String item) { 
        try {
            while (queue.size() == maxSize) {
                wait();
            }
            queue.add(item);
            notifyAll();
        }
        catch (InterruptedException e) {
        }
    } 
    public synchronized String dequeue() { 
        try{
            while(queue.isEmpty()){
                wait();
            }
            String message = queue.remove();
            notifyAll();
            return message; 
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    } 
   
}
