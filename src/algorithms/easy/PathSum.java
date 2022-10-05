package algorithms.easy;

/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 */

public class PathSum {
    private boolean found;
    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        found = false;
        this.targetSum = targetSum;

        preOrderTraversal(root, 0);

        return found;
    }

    private void preOrderTraversal(TreeNode node, int sum) {
        if (node == null) return;

        sum += node.val;

        if (node.left == null & node.right == null) {
            if (sum == targetSum) found = true;
            return;
        }

        preOrderTraversal(node.left, sum);
        preOrderTraversal(node.right, sum);
    }
}
