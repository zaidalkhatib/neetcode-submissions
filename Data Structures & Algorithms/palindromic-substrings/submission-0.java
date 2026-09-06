class Solution {
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0 ;i<s.length() ;i++){
            int left=i;
            int right=i;
            int count=0;
            while(right<s.length()&&left>=0&&s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
            res+=count;
            left=i;
            right=i+1;
            count=0;
            while(right<s.length()&&left>=0&&s.charAt(left)==s.charAt(right)){
                count++;
                right++;
                left--;
            }
            res+=count;
        }
        return res;
    }
}
