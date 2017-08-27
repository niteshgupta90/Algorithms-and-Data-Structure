/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Given a binary tree, flatten it to a linked list in-place.
class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        
        TreeNode node = root;
        while (node!=null) {
            
            // Attatches the right sub-tree to the rightmost leaf of the left sub-tree:
            if (node.left!=null) {
                
                TreeNode rightMost = node.left;
                while (rightMost.right!=null) {
                    
                    rightMost = rightMost.right;
                }
                rightMost.right = node.right;
                
                // Makes the left sub-tree to the right sub-tree:
                node.right = node.left;
                node.left = null;
            }
            
            // Flatten the rest of the tree:
            node = node.right;
        }     
    }
}
