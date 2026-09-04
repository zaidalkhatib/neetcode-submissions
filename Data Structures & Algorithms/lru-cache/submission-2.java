class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);

        // remove node
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;

        // add to front
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

        return node.val;
    }

    public void put(int key, int value) {
        // add
        if (map.containsKey(key)) {
            Node node = map.get(key);
            System.out.print(node.val);
            map.remove(key);
            // remove Node
            Node nodePrev = node.prev;
            Node nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
        }
        //remove last Node
        else if (map.size() >= capacity) {
            Node lastNode = tail.prev; 
            map.remove(lastNode.key);
            lastNode.prev.next = tail;
            tail.prev = lastNode.prev;
        }

        //add the Node to the front
        Node node = new Node(key,value);
        map.put(key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

    }

    static class Node {
        int val;
        int key;
        Node prev = null;
        Node next = null;
        public Node(int key, int val) {
            this.val = val;
            this.key =key;
        }
    }
}
