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
    private void inOrder(TreeNode root, int [] count, int [] ans, int k){
        if(root==null){
            return;
        }
        inOrder(root.left,count, ans,k);
        count[0]++;
        if(count[0]==k){
            ans[0]=root.val;
            return;
        }
        inOrder(root.right,count, ans,k);

    }
    public int kthSmallest(TreeNode root, int k) {
        int [] count=new int[1];
        int [] ans = new int[1];
        inOrder(root, count, ans, k);
        return ans[0];
    }
}
