class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int start=0;
        int max=0;
        for(int end=0 ;end<s.length() ;end++){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }
            set.add(s.charAt(end));
            max=Math.max(end-start+1,max);
        }
        return max;
    }
}
