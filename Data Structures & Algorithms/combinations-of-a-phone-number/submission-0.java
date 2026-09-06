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
        helper(res,map,digits,new StringBuilder(),0);
        return res;
    }


    private static void helper(List<String> res,Map<Character, String> map,String digits,StringBuilder curr,int index){
        if(curr.length()==digits.length()){
            res.add(new String(curr.toString()));
            return;
        }
        if(index>=digits.length()){
            return;
        }
        String chars = map.get(digits.charAt(index));
        for(int i=0 ;i<chars.length() ;i++){
            curr.append(chars.charAt(i));
            helper(res,map,digits,curr,index+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
