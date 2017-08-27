/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Level Order Traversal of Binary Tree
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        List<TreeNode> temp = new LinkedList<TreeNode>();
        
        temp.add(root);
        temp.add(new TreeNode(Integer.MAX_VALUE));
        while(temp!=null && (temp.get(0)).val!=Integer.MAX_VALUE){
            List<Integer> data = new ArrayList<Integer>();
            TreeNode node = temp.remove(0);
            
            while(node.val!=Integer.MAX_VALUE){
                if(node.left!=null) temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
                data.add(node.val);
                node = temp.remove(0);
            }
            res.add(data);
            temp.add(new TreeNode(Integer.MAX_VALUE));
        }
        return res;
        
    }
}
