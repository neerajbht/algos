package list;

public class MyDoubleLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this(val, null, null);
        }

        ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    ListNode head;
    ListNode tail;
    int size;

    public MyDoubleLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

}
