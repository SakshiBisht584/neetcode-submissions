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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ansList;
        q.offer(root);
        while(!q.isEmpty()){
            int qSize=q.size();
            List<Integer> l1=new LinkedList<>();
            for(int i=0;i<qSize;i++){
                if(q.peek().left !=null) q.offer(q.peek().left);
                    
                if(q.peek().right !=null) q.offer(q.peek().right);
                    
                l1.add(q.poll().val);
            }
            ansList.add(l1);
        }
        return ansList;

    }
}
