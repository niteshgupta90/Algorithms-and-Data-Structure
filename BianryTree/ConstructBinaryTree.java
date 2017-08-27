/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Binary Tree from Preorder and Inorder Traversal
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int left, int right) {
        if(left>right)
            return null;
        if(preIndex>=preorder.length)
            return null;
        TreeNode node = new TreeNode(preorder[preIndex]);
        int inIndex = getIndex(inorder,preorder[preIndex],left,right);
        node.left = buildTree(preorder, inorder, preIndex+1, left, inIndex-1);
        node.right = buildTree(preorder, inorder, preIndex+inIndex-left+1, inIndex+1, right);
        return node;
    }
    public int getIndex(int[] inorder, int val, int left, int right){
        int i = left;
        for(;i<=right;i++){
            if(inorder[i]==val)
                return i;
        }
        return -1;
    }
}
