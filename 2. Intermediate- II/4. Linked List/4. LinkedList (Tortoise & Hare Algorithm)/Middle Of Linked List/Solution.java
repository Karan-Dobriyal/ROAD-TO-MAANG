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

        //  Middle of a Linked List
        Node inputList = convertArrayToLL(arr); 
        System.out.println(" Middle Of Linked List");
        Node midLL = middleOfLinkedList(inputList); 
        printLinkedList(midLL);
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

    // Middle of a Linked List
    private static Node middleOfLinkedList(Node head)
    {
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next != null) return slow.next;
        return slow;
    }
}

