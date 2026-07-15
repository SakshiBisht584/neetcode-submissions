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
    public void inorder(TreeNode root,ArrayList<Integer> a){
        if(root!=null){
            inorder(root.left,a);
            a.add(root.val);
            inorder(root.right,a);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        ArrayList<Integer> a=new ArrayList<>();
        inorder(root,a);
        int[] ans=new int[a.size()];
        for(int i=0;i<a.size();i++){
            ans[i]=a.get(i);
        }
        return ans[k-1];
    }
}
