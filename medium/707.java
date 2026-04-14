/*
707. Design Linked List

Approach : 
1. Design
    Implement a singly linked list using a Node class (val, next).
    Maintain head, tail, and size c.
2. Get
    If index invalid → return -1.
    Traverse from head to the given index.
3. Add at Head
    Create new node → point it to current head.
    Update head (and tail if list was empty).
4. Add at Tail
    Create new node → attach after tail.
    Update tail (or initialize if empty).
5. Add at Index
    If index invalid → do nothing.
    If 0 → add at head.
    If c → add at tail.
    Else:
      Traverse to (index - 1)
      Insert node in between.
6. Delete at Index
    If index invalid → do nothing.
    If 0 → move head forward.
    Else:
      Traverse to (index - 1)
      Skip the target node
      Update tail if last node removed.
7. Key Idea
    Maintain correct links and update head, tail, and size after every operation.
*/

class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head, tail;
    int c;

    public MyLinkedList() {
        head = tail = null;
        c = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= c) return -1;

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.val;
    }

    public void addAtHead(int val) {
        Node nn = new Node(val);
        if (head == null) {
            head = tail = nn;
        } else {
            nn.next = head;
            head = nn;
        }
        c++;
    }

    public void addAtTail(int val) {
        Node nn = new Node(val);
        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
        c++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > c) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == c) {
            addAtTail(val);
            return;
        }

        Node nn = new Node(val);
        Node temp = head;

        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        nn.next = temp.next;
        temp.next = nn;

        c++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= c) return;

        if (index == 0) {
            head = head.next;
            c--;
            if (c == 0) tail = null;
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        temp.next = temp.next.next;

        if (temp.next == null)
            tail = temp;

        c--;
    }
}

