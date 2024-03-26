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

        // Odd Even Linked List 
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Odd Even Linked List");
        Node oddEven = OddEvenLinkedList(inputList); 
        printLinkedList(oddEven);
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
    private static Node OddEvenLinkedList(Node head)
    {
        if(head == null)
        {
            return null;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}

