class Node {
    public int data;
    public Node next;

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

        // Find Intersection Node
        int[] arr1 = {4,5};
        int[] arr2 = {1,2,3,4,6,7,8,9};
        Node head1 = convertArrayToLL(arr1); 
        Node head2 = convertArrayToLL(arr2); 
        System.out.println("Intersection Node");
        Node intLL = getIntersectionNode(head1,head2); 
        printLinkedList(intLL);
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

    // Intersecting Node
    private static Node getIntersectionNode(Node head1, Node head2)
    {
        Node t1 = head1;
        Node t2 = head2;

        while(t1 != t2)
        {
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2) return t1;

            if(t1 == null) t1 = head2;
            if(t2 == null) t2 = head1;
        }
        return head1;
    }
}

