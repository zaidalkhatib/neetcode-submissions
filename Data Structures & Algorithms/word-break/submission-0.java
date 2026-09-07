class Solution {
    Map<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.length()==0) return true;
        for(String word : wordDict){
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()),wordDict)){
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
}
