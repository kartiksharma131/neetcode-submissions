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
    private void inOrderHelper(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        inOrderHelper(root.left,ans);
        ans.add(root.val);
        inOrderHelper(root.right, ans);
    }
    private void inOrderIterative(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ans.add(node.val);
                node=node.right;
            }
        }

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderIterative(root,ans);
        return ans;
    }
}