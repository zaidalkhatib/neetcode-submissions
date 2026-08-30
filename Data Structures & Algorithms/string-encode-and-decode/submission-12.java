class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "").append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        System.out.println(str + " " + str.length());
        int i = 0;
        int prevEndPosition = -1;
        while (i < str.length()) {
            if (str.charAt(i) == '#') {
                int j = i - 1;
                String numAsStr="";
                while (prevEndPosition < j) {
                    numAsStr=str.charAt(j)+numAsStr;
                    j--;
                }
                int num=Integer.parseInt(numAsStr);
                i++;
                prevEndPosition=i+num-1;
                res.add(str.substring(i, (i + num)));
                i += num;
            } else {
                i++;
            }
        }
        return res;
    }
}

/*
#5
Hello","World,3#zaid4#
6#hello35#World8#3#zaid4#

*/
