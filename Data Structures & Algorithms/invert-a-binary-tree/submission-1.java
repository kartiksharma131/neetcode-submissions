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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left==null){
            TreeNode invertedRight = invertTree(root.right);
            root.left = invertedRight;
            root.right=null;
            return root;
        }
        if(root.right==null){
            TreeNode invertedLeft = invertTree(root.left);
            root.right = invertedLeft;
            root.left =null;
            return root;
        }
        if(root.left!=null && root.right!=null){
            TreeNode invertedRight = invertTree(root.right);
            TreeNode invertedLeft = invertTree(root.left);
            root.left = invertedRight;
            root.right = invertedLeft;
            
        }
        return root;
    }
}
