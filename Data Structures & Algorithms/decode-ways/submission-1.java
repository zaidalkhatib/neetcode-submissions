class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        if(map.containsKey(s)) return map.get(s);
        if (s.length() == 0) {
            return 1;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int count = 0;

        for (int i = 1; i <= Math.min(s.length(), 2); i++) {

            if (Integer.parseInt(s.substring(0, i)) > 26) {
                continue;
            }

            count += numDecodings(s.substring(i));
        }
        map.put(s,count);
        return count;
    }
}