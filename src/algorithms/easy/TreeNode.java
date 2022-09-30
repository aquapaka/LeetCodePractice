package algorithms.easy;

public class TreeNode {
    public int val;
    public algorithms.medium.TreeNode left;
    public algorithms.medium.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, algorithms.medium.TreeNode left, algorithms.medium.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
