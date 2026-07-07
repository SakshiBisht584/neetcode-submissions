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
    int count=0;
    public void good(TreeNode root, int maxval){
        if(root==null) return;
        if(root.val>=maxval) count++;
        maxval=Math.max(root.val,maxval);
        good(root.left,maxval);
        good(root.right,maxval); 
        
    }
    public int goodNodes(TreeNode root) {
        if (root==null) return 0;
        good(root,root.val);
        return count;
    }
}
