package HashMap_HashFunction;

class MyHashMap {

    // Node to store key-value pair
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000; // size of the bucket array
    private Node[] buckets;

    // Constructor to create bucket array
    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function to find index
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Insert or update value for a key
    public void put(int key, int value) {
        int index = getIndex(key);

        Node head = buckets[index];

        // If no node at index, add new
        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        // Search for key in linked list
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value; // update if found
                return;
            }
            if (current.next == null)
                break;
            current = current.next;
        }

        // Key not found, add at end
        current.next = new Node(key, value);
    }

    // Get the value for a key
    public int get(int key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1; // key not found
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next; // head node removed
                } else {
                    prev.next = current.next; // link skipped
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        System.out.println("Value for key 2: " + map.get(2)); // Output: 20

        map.put(2, 25);
        System.out.println("Updated value for key 2: " + map.get(2)); // Output: 25

        map.remove(2);
        System.out.println("Value for key 2 after deletion: " + map.get(2)); // Output: -1
    }
}

// Implement a Custom Hash Map
// Problem: Design and implement a basic hash map class with operations for
// insertion, deletion, and retrieval.
// Hint: Use an array of linked lists to handle collisions using separate
// chaining