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

public class Codec {
   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                s.append("null"+" ");
                continue;
            }
            s.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] values=data.split(" ");
        if(values[0].equals("null")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1; i<values.length;i++){
            TreeNode node=q.poll();
            if(!values[i].equals("null")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                node.left=left;
                q.offer(left);
            }
            if(!values[++i].equals("null")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                node.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}
