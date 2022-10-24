package algorithms.easy;/*
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
*/

public class TwoSumIVInputIsABST {
    private TreeNode root;
    private boolean isFound;
    
    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        isFound = false;
        
        traverse(root, k);
        
        return isFound;
    }
    
    public void traverse(TreeNode node, int k) {
        if (node == null) return;
        
        checkTraverse(root, node, k);
        
        traverse(node.left, k);
        traverse(node.right, k);
    }
    
    public void checkTraverse(TreeNode node, TreeNode exclude, int k) {
        if (node == null) return;
        
        if(node != exclude) {
            if((node.val + exclude.val) == k) {
                isFound = true;
            }
        }
        
        checkTraverse(node.left, exclude, k);
        checkTraverse(node.right, exclude, k);
    }
}
