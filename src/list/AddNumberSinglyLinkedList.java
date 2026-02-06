package list;

/**
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddNumberSinglyLinkedList {

    public ListNode addListNodes(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);

        ListNode tail = result;
        int carry = 0;
        /**
         * so we iterate over the both the nodes while they are not null and serially
         * compute sum and add to new nodde
         * tail should alway point to that node fillany we point result to tail
         * 
         */

        while (l1 != null || l2 != null || carry != 0) {

            int num1 = 0, num2 = 0, sum = 0;
            ;
            if (l1 != null)
                num1 = l1.val;
            if (l2 != null)
                num2 = l2.val;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            // carry goes to node
            ListNode tempNode = new ListNode(sum % 10);
            // ponit tail to next ;
            tail.next = tempNode;
            // move tail
            tail = tail.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return result;
    }

}
