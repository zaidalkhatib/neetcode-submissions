class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return List.of();
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res =new ArrayList<>();
        helper(res,map,digits,"",0);
        return res;
    }


    private static void helper(List<String> res,Map<Character, String> map,String digits,String curr,int index){
        if(curr.length()==digits.length()){
            res.add(curr);
            return;
        }
        if(index>=digits.length()){
            return;
        }
        String chars = map.get(digits.charAt(index));

        for(int i=0 ;i<chars.length() ;i++){
            helper(res,map,digits,curr+chars.charAt(i),index+1);
        }
    }
}
