class LRUCache {
    int capacity;
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove(list.indexOf(key));
            list.addFirst(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            list.remove(list.indexOf(key));
        }
        if(map.size()>=capacity){
            int leastUsedIndex = list.get(list.size()-1);
            list.removeLast();
            map.remove(leastUsedIndex);
        }
        list.addFirst(key);
        map.put(key,value);
    }
}
/*




*/