class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }
    // Constructor with only Data 
    Node(int data)
    {
        this.data = data;
    }

    // Constructor with Data and Pointer
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class Solution
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr); 
        Node dummyHead = head; 
        System.out.println("Original Linked List");
        printLinkedList(dummyHead);
        System.out.println();
        System.out.println();

        // Delete Kth Node From End
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Deleted Kth Node from End");
        Node newLL = deleteKNodeFromEnd(inputList,2); 
        printLinkedList(newLL);
    }

    // Convert array into the linked list.
    private static Node convertArrayToLL(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i=1; i<arr.length; i++)
        {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        } 
        return head;
    }
    
    // Print the Linked List
    private static void printLinkedList(Node head)
    {
        Node temp = head;  
        while(temp != null)
        {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    // Odd Even Linked List
    private static Node deleteKNodeFromEnd(Node head, int K)
    {
        Node fast = head;
        Node slow = head;

        for(int i=0; i<K; i++) fast = fast.next;

        if(fast == null) return head.next;

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

