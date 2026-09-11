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
    int res=0;
    public int goodNodes(TreeNode root) {
	        return helper(root, Integer.MIN_VALUE);
               
    }

    private int helper(TreeNode root,int prevMax){
        if(root==null){
            return 0;
        }
        int res=0;
        if(root.val>=prevMax){
            res=1;
        }
        int left = helper(root.left,Math.max(prevMax,root.val));
        int right = helper(root.right,Math.max(prevMax,root.val));
        return res+left+right;
    }

    /*

    we will pass the max prev of the node


    */
}
