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
	        helper(root, Integer.MIN_VALUE);
               return res;
    }

    private void helper(TreeNode root,int prevMax){
        if(root==null){
            return;
        }
        // System.out.println("prevMax: "+prevMax+" current;"+root.val );
        if(root.val>=prevMax){
            res++;
        }
        helper(root.left,Math.max(prevMax,root.val));
        helper(root.right,Math.max(prevMax,root.val));
    }

    /*

    we will pass the max prev of the node


    */
}
