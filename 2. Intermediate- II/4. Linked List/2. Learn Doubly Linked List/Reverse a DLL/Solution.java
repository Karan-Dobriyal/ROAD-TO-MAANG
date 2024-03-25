class Node {
    public int data;
    public Node next;
    public Node prev;

    // Constructor with only Data 
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Constructor with Data and Pointer
    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    } 
}

public class Solution
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6};
        Node head = convertArrayToDLL(arr);
        Node dummyHead = head;
        printLinkedList(dummyHead);  

        // 1. Reverse a DLL 
        Node LL1 = convertArrayToDLL(arr);
        Node revDLL = reverseDLL(LL1); 
        System.out.println();
        System.out.println();
        System.out.println("Reverse DLL");
        printLinkedList(revDLL); 
    }

    // Convert Array to Doubly Linked List
    private static Node convertArrayToDLL(int[] arr)
    {
        Node head =  new Node(arr[0]);
        Node prev = head;

        for(int i=1; i<arr.length; i++)
        {
            Node newNode = new Node(arr[i],null,prev);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    } 

    // Print the Doubly Linked List
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

    // Reverse a DLL
    private static Node reverseDLL(Node head)
    {
        if(head == null || head.next == null) return head;
        Node current = head;
        Node prev = null;

        while(current != null)
        {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
    } 
}
 
