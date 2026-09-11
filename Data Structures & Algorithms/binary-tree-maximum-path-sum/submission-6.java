/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private  int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= helper(root.left);
        int right= helper(root.right);
        // System.out.println("root "+root.val+" left "+left+ " right"+right);
        left = Math.max(left,0);
        right = Math.max(right,0);
        res=Math.max(res,left+right+root.val);

        return Math.max(left,right)+root.val;
    }
}
