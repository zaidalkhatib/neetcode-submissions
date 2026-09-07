class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        int res = helper(text1, text2);
        // System.out.print(Integer.MIN_VALUE);
        return res;
    }

    private int helper(String text1, String text2) {
        String key = text1 +"+"+ text2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        if (text1.charAt(0) == text2.charAt(0)) {
            return 1 + helper(text1.substring(1, text1.length()), text2.substring(1, text2.length()));
        }
        map.put(key,Math.max(helper(text1, text2.substring(1, text2.length())),
            helper(text1.substring(1, text1.length()), text2)));
            return map.get(key);
    }
}
