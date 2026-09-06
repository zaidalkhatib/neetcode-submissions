class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();

        helper(res, n, n, new StringBuilder());
        return new ArrayList<>(res);
    }

    private static void helper(Set<String> res, int open, int closed, StringBuilder curr) {
        if (open == 0 && closed == 0) {
            String  copy = new String(curr.toString());
            res.add(copy);
            return;
        }
        if (open > 0) {
            curr.append("(");
            helper(res, open - 1, closed, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (closed>open) {
            curr.append(")");
            helper(res, open, closed - 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
