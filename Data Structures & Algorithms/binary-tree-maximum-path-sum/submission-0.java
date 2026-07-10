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
    int maxv=Integer.MIN_VALUE;
    public int maxValue(TreeNode root){
        if(root==null) return 0;
        int leftSum=Math.max(0,maxValue(root.left));
        int rightSum=Math.max(0,maxValue(root.right));
        maxv=Math.max(maxv,leftSum+rightSum+root.val);
        return root.val+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        
        maxValue(root);
        return maxv;
        
    }
}
