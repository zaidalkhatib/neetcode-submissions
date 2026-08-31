class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;
        for (char val : s1.toCharArray()) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            if (map.containsKey(s2.charAt(end))) {
                map.put(s2.charAt(end), map.get(s2.charAt(end)) - 1);
                if (map.get(s2.charAt(end)) >= 0) {
                    match++;
                }
            }
            System.out.print(map);
            if (match == s1.length()) {
                return true;
            }
            if ((end - start + 1) == s1.length()) {
                if (map.containsKey(s2.charAt(start))) {
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    if (map.get(s2.charAt(start)) > 0) {
                        match--;
                    }
                }
                start++;
            }
        }
        // System.out.print(map);
        System.out.print(match);
        return match == s1.length();
    }

    /*
    check if the match==s1.length
    */
}
