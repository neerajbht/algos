package list;

public class DoublyLinkedList {

    DoublyListNode head;
    DoublyListNode tail;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;

    }

    public void removeLast() {
        if (tail == null)
            return;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    public void removeFirst() {
        if (head == null) {
            tail = null;
            return;
        }
        head.next.next.prev = head;
        head.next = head.next.next;
    }

    public void addFirst(Object data) {
        // create new node

        DoublyListNode newNode = new DoublyListNode(data);
        // impt head object is referencing to n1 and not like head.next =n1
        // head == >>>>>>>>>>>>>>>>>>>>>> null|n1|n --------- p|n2|null == <---- tail
        // <- null|newNode|null ->
        // if head and tail are empty point them both to new node

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = head; // connecttion left
            newNode.next = head.next; // connection right
            head.next.prev = newNode; /// connect n1.prev to new node n1.prev is head.next.prev
            head.next = newNode; // point head newNode
        }

    }

    public void addLast(Object data) {

        // create new node
        DoublyListNode newNode = new DoublyListNode(data);

        // if head and tail are empty point them both to new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        // impt head object is referencing to n1 and not like head.next =n1
        // head == >>>>>> null|n1|n --------- p|n2|null == <---- tail
        // <-------------------------------------------- null|newNode|null ->

        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode; // ppint lastNode earler to newNode;
        tail.prev = newNode;

    }

    public void addAfterNode(DoublyListNode prevNode, Object data) {
        if (prevNode == null)
            return;
        DoublyListNode newNode = new DoublyListNode(data);

        // impt head object is referencing to n1 and not like head.next =n1
        // head == >>>>>> null|n1|-> ---p|n2|->----------- ----p|n3|null == <---- tail
        // prevNode =n2
        // <---------------------- ------------null|newNode|null ->
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;

        } else {
            tail = newNode;
        }

    }
}
