class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<order.length() ;i++){
            map.put(order.charAt(i),i);
        }

        for(int i=0 ;i<words.length-1 ;i++){
            String firstWord = words[i];
            String secondWord = words[i+1];
            int len1=firstWord.length();
            int len2=secondWord.length();
            int min = Math.min(len1,len2);
            boolean flag=false;
            for(int j=0 ;j<min ;j++){
                if(map.get(firstWord.charAt(j))>map.get(secondWord.charAt(j))){
                    return false;
                }else if(map.get(firstWord.charAt(j))<map.get(secondWord.charAt(j))){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                if(len1>len2){
                    return false;
                }
            }
        }
        return true;
    }
}