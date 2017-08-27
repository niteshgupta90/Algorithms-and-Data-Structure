/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Validate if given tree is valid BST
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null)
            return true;
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max){
        boolean isLeft = true;
        boolean isRight = true;
        
        if(root.val<=min || root.val>=max)
            return false;
        if(root.left==null && root.right==null)
            return true;
        if(root.left!=null)
            isLeft = isValidBST(root.left,min,root.val);
        if(root.right!=null)
            isRight = isValidBST(root.right,root.val,max);
        return isLeft&&isRight;
    }
}
