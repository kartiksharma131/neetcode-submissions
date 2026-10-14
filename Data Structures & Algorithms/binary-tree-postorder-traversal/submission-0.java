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
    private void postorderHelper(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        postorderHelper(root.left, ans);
        postorderHelper(root.right, ans);
        ans.add(root.val);

    }

    private void postOrderIterative(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();

            if(top.left!=null){
                st.push(top.left);
            }
            if(top.right!=null){
                st.push(top.right);
            }
            ans.add(top.val);
        }
        Collections.reverse(ans);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderIterative(root,ans);
        return ans;
    }
}