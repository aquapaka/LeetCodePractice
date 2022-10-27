package algorithms.easy;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Check if 2 list are empty
        if(list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else {
            ListNode current1 = list1;

            // Travel through all node in list1
            while (current1 != null) {
                ListNode newNode = new ListNode(current1.val);

                // Check if newNode belong to head of list2
                if (newNode.val < list2.val) {
                    newNode.next = list2;
                    list2 = newNode;
                    current1 = current1.next;
                    continue;
                }

                ListNode current2 = list2.next;
                ListNode prev = list2;

                // Find position of newNode in list2
                while(current2 != null) {
                    if (newNode.val < current2.val) {
                        newNode.next = current2;
                        prev.next = newNode;
                        break;
                    }

                    current2 = current2.next;
                    prev = prev.next;
                }

                // Check if newNode belong to last node of list2
                if (current2 == null) prev.next = newNode;

                current1 = current1.next;
            }
        }

        return list2;
    }
}
