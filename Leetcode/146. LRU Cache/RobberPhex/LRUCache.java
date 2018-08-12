import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> hashmap;
    private Node head, tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        hashmap = new HashMap<Integer, Node>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        Node ret = hashmap.get(key);
        if (ret != null) {
            this.removeNode(ret);
            this.addToHead(ret);
            return ret.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node tries = hashmap.get(key);
        if (tries != null) {
            tries.value = value;
            this.removeNode(tries);
            this.addToHead(tries);
        } else {
            if (size >= capacity) {
                int keyToRemove = tail.prev.key;
                this.removeNode(tail.prev);
                hashmap.remove(keyToRemove);
                size--;
            }
            Node c = new Node(key, value);
            hashmap.put(key, c);
            this.addToHead(c);
            size++;
        }
    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.set(2, 1);
        l.set(2, 2);
        System.out.println(l.get(2));
        l.set(1, 1);
        l.set(4, 1);
        System.out.println(l.get(2));
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
