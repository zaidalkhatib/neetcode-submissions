class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prev =strs[0];
        for(int i=1 ;i<strs.length ;i++){
            int len = Math.min(prev.length(),strs[i].length());
            int j=0;
            for(j=0; j<len; j++){
                if(prev.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            prev=prev.substring(0,j);
        }
        return prev;
    }


    /*
    compare prev with current first prev would be the whole world but then we can update prev to the longest prefix from prev 2 words

    */
}