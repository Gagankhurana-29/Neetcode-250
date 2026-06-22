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
    StringBuilder sb = new StringBuilder("");
    public String serialize(TreeNode root) {
        if(root==null) return "#";
        return root.val + "," +serialize(root.left) + "," + serialize(root.right);   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i={0};
        String[] tokens = data.split(",");
        return dHelper(tokens,i);
    }

    public TreeNode dHelper(String[] tokens,int[] i){
        if(tokens[i[0]].equals("#")){
            i[0]++;
            return null;
        } 
        TreeNode root = new TreeNode(Integer.parseInt(tokens[i[0]++]));
        root.left = dHelper(tokens,i);
        root.right = dHelper(tokens,i);
        return root;
    }
}
