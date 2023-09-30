class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CycleDetection {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle
        
        CycleDetection detector = new CycleDetection();
        boolean hasCycle = detector.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle);
    }
}
/*This Java program is designed to detect cycles in a linked list. The main components are:

1. **ListNode class:**
    - Represents a node in a singly linked list.
    - It has an integer value (`val`) and a reference to the next node (`next`).
    - The constructor initializes the node with a given value and sets the next node to null.

2. **CycleDetection class:**
    - Contains a method `hasCycle` that takes the head of a linked list as input and returns a boolean indicating whether the linked list contains a cycle.
    - It uses the Floyd's Tortoise and Hare algorithm, a two-pointer technique, where one pointer (`slow`) advances one node at a time, and another pointer (`fast`) advances two nodes at a time.
    - If there is a cycle, the `fast` pointer will eventually catch up with the `slow` pointer, detecting the cycle.

3. **Main method:**
    - Creates a linked list with nodes having values 3, 2, 0, -4, and creates a cycle by making the last node point to the second node.
    - Creates an instance of `CycleDetection`.
    - Calls the `hasCycle` method with the head of the linked list and prints whether the linked list has a cycle.

In the provided example, the linked list has a cycle, so running the program would print "Has Cycle: true." If there were no cycle, it would print "Has Cycle: false."*/
