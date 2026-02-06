package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKlist {

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> nodes = new ArrayList<>();
        ListNode head = new ListNode(0);
        ListNode point = head;
        for (ListNode l : lists) {
            while (l != null) {
                nodes.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(nodes);
        for (int x : nodes) {
            point.next = new ListNode(x);
            point = point.next;
        }
        return head.next;
    }

    public ListNode mergeKListsPQ(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val > o2.val) {
                            return 1;
                        } else if (o1.val == o2.val) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return divideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = divideAndConquer(lists, left, mid);
        ListNode l2 = divideAndConquer(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
