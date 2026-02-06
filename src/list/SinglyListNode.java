package list;

public class SinglyListNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    ListNode head;
    ListNode tail;

    SinglyListNode(int val) {
        this.head = new ListNode(val);
        this.tail = head;
    }

    void add(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode cur = new ListNode(val);
            ListNode t = head;
            while (t.next != null) {
                t = t.next;
            }
            t = cur;

        }

    }

    public void insertEnd(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }

    // node ------> a| next---> b|next-----C---.....tail
    void remove(int index) { // i = index position of b
        int i = 0;
        ListNode curr = head;
        while (i < index && curr != null) { // move untill a
            i++;
            curr = curr.next;
        }
        // make sure a is not last but middle node in list
        if (curr != null && curr.next != null) {
            // check if a is last
            if (curr.next == tail) {
                tail = curr;
            }
            // otherwise ponit a.next to c ( curr.next is b and bis to be deleted and b.next
            // is c from a we c
            // a ref to c --- a.next.next )
            curr.next = curr.next.next; // point curr (node a to c of where curr.next =b (node being deleted)
        }

    }

    public ListNode reverseLinkedList(ListNode head) {
        // node ------> a| next---> b|next-----C---.....tail
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // temp to b
            ListNode temp = curr.next;
            // b to pre b
            curr.next = pre;
            pre = curr;
            curr = temp;

        }
        return pre;
    }

}