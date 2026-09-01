class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int start=0;
        int res=0;
        int maj=0;
        for(int end=0 ; end<s.length() ; end++){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            for(char key : map.keySet()){
                maj = Math.max(maj,map.get(key));
            }
            if((end-start+1)-maj>k){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start))==0){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}
