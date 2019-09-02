import java.util.*; 

class LRUCache {

    private class Node {
        int key;
        int value;
        
        Node previous;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
        
        public int getKey() {
            return key;
        }
        
        public void putValue(int value) {
            this.value = value;
        }
    }
    
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node headPtr = new Node(-1,-1);
    private Node tailPtr = new Node(-1,-1);
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        headPtr.next = tailPtr;
        tailPtr.previous = headPtr;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node getNode = map.get(key);
            evict(getNode);
            addToFront(getNode);
            return getNode.getValue();
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            evict(curNode);
            curNode.putValue(value);
            addToFront(curNode);
            return;
        }
        
        if (map.size() == capacity) {
            Node eNode = evict(tailPtr.previous);
            map.remove(eNode.getKey());
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);
    }
    
    private Node evict(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.previous = null;
        node.next = null;
        return node;
    }
    
    private void addToFront(Node node) {
        node.next = headPtr.next;
        node.previous = headPtr;
        node.next.previous = node;
        headPtr.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */