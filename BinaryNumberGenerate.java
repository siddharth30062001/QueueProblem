package QueueProblem;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerate {
    
    
    public static void generateBinaryNumbers(int n) {
       
        Queue<String> queue = new LinkedList<>();
        
       
        queue.offer("1");
        
        
        for (int i = 1; i <= n; i++) {
           
            String current = queue.poll();
            
           
            System.out.println(current);
            
            
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10; 
        generateBinaryNumbers(n);
    }
}
