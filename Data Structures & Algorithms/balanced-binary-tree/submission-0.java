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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(ans==false) return false;
        helper(root);
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode root)
    {
        if(root==null) return 0;
        int lh = helper(root.left);
        int rh = helper(root.right);
        if(Math.abs(lh-rh)>1) ans = false;
        return 1 + Math.max(lh,rh);
    }
}
