class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution
{
    public Node copyRandomList(Node head) {
        if (head == null)  return null;
          
      // Step 1: Create a new node for each node in the original list and
      // insert it next to the original node.
      Node curr = head;
      while (curr != null) 
      {
        Node newNode = new Node(curr.val);
        newNode.next = curr.next;
        curr.next = newNode;
        curr = newNode.next;
      }

      // Step 2: Assign random pointers for the new nodes.
      curr = head;
      while (curr != null) 
      {
        if (curr.random != null)   curr.next.random = curr.random.next; 
        curr = curr.next.next;
      }

      // Step 3: Separate the original and copied lists.
      Node original = head;
      Node copied = head.next;
      Node copiedHead = head.next;
      while (original != null) 
      {
        original.next = original.next.next;
        if (copied.next != null)  copied.next = copied.next.next; 
        original = original.next;
        copied = copied.next;
      } 
      return copiedHead;
  }
}

