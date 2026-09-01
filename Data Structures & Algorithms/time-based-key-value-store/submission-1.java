class TimeMap {
    Map<String,Map<Integer,String>> map = new HashMap<>();
    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new HashMap<Integer,String>());
        }
        map.get(key).put(timestamp,value);
        // System.out.print(map);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
          Map<Integer,String> innerMap = map.get(key);

          if(innerMap.containsKey(timestamp)){
            return innerMap.get(timestamp);
          }else{
            for(int i=timestamp-1 ;i>=0 ;i--){
                if(innerMap.containsKey(i)){
                    return innerMap.get(i);
                }
            }
          }
        }
        return "";
    }
}
