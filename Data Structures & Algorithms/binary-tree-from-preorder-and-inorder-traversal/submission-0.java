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
    public TreeNode build(int[] preorder,int pst,int pend, int[] inorder, int ist, int iend,Map<Integer,Integer> map){
        if(pst>pend || ist>iend) return null;
        TreeNode root=new TreeNode(preorder[pst]);
        int inRoot=map.get(root.val);
        int numleft=inRoot-ist;
        root.left=build(preorder,pst+1,pst+numleft,inorder,ist,inRoot-1,map);
        root.right=build(preorder,pst+numleft+1,pend,inorder,inRoot+1,iend,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
}
