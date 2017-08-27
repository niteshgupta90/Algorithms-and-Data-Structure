/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Given a binary tree, find the maximum path sum.
class Solution {
    public int maxSum  = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }
    
    public int maxPath(TreeNode root) {
        if(root==null)
            return 0;
        
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        int maxSingle = Math.max(Math.max(l,r)+root.val,root.val);
        
        int maxOverall = Math.max(l+r+root.val,maxSingle);
        if(maxOverall>maxSum)
            maxSum = maxOverall;
        return maxSingle;
    }
}
