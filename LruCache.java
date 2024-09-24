package QueueProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LruCache {
    
    private final int capacity;
    private Map<Integer, Integer> cache;
    private Queue<Integer> queue;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        queue = new LinkedList<>();
    }

    // Get the value of a key if it exists in the cache
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        queue.remove(key); // Remove the key and reinsert it to mark it as most recently used
        queue.add(key);
        return cache.get(key);
    }

    // Insert or update the value of a key
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            queue.remove(key); // Update key position in the queue
        } else if (cache.size() == capacity) {
            int oldest = queue.poll(); // Remove the least recently used key
            cache.remove(oldest);
        }
        queue.add(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // Output: 10
        cache.put(3, 30);                 // Removes key 2
        System.out.println(cache.get(2)); // Output: -1 (not found)
        cache.put(4, 40);                 // Removes key 1
        System.out.println(cache.get(1)); // Output: -1 (not found)
        System.out.println(cache.get(3)); // Output: 30
        System.out.println(cache.get(4)); // Output: 40
    }
}
