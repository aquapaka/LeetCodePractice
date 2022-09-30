package algorithms.medium;

/*
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.



Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AllElementsInTwoBinarySearchTrees {
    private List<Integer> results;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        results = new ArrayList<>();

        travelAndAdd(root1);
        travelAndAdd(root2);

        return results.stream().sorted().collect(Collectors.toList());
    }

    private void travelAndAdd(TreeNode node) {
        if(node == null) return;

        results.add(node.val);
        travelAndAdd(node.left);
        travelAndAdd(node.right);
    }
}
