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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                int numsLeft = i;
                root.left = buildTree(preorder, 1, numsLeft, inorder, 0, i - 1);
                root.right = buildTree(preorder, numsLeft + 1, preorder.length - 1, inorder, i + 1, inorder.length - 1);
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preS, int preE, int[] inorder, int s, int e) {
        if (e < s || preE < preS) return null;
        
        TreeNode root = new TreeNode(preorder[preS]);
        for (int i = s; i <= e; i++) {
            if (preorder[preS] == inorder[i]) {
                int numsLeft = i - s;
                root.left = buildTree(preorder, preS + 1, preS + numsLeft, inorder, s, i - 1);
                root.right = buildTree(preorder, preS + numsLeft + 1, preE, inorder, i + 1, e);
                break;
            }
        }
        return root;
    }
}