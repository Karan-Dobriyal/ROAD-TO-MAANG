import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}
  

public class Solution
{
    public static void main(String[] args) { 

        // Define the provided sorted lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
    
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
    
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
    
        // Merge lists using the function
        ListNode result = mergeKLists(new ListNode[]{list1, list2, list3});
    
        // Print the merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static  ListNode mergeKLists(ListNode[] lists) {
        // Define a dummy node to simplify the result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
    
        // Create a priority queue (min-heap)
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
    
        // Initialize the heap with the first element from each list
        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }
    
        // Merge lists until the heap is empty
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null)
                heap.add(node.next);
        }
    
        return dummy.next;
    }
}
