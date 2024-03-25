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

        // Deletion from a Linekd List.

        // 1. Delete the Head
        Node newHead = deleteHeadFromFirst(dummyHead); 
        System.out.println();
        System.out.println();
        System.out.println("Delete From Head");
        printLinkedList(newHead);

        // 2. Delete From the Specific Element
        int element = 2;
        Node newLinkedList = deleteElement(dummyHead,element);
        System.out.println();
        System.out.println();
        System.out.println("Delete Specific Element " + element);
        printLinkedList(newLinkedList);

        // 3. Delete From the Specific Postion
        int k = 7;
        Node newLL = deleteFromPosition(dummyHead,k);
        System.out.println();
        System.out.println();
        System.out.println("Delete From Postion " + k);
        printLinkedList(newLL);

        // 4. Delete from the Tail
        Node newTail = deleteHeadFromLast(dummyHead); 
        System.out.println();
        System.out.println();
        System.out.println("Delete From Tail");
        printLinkedList(newTail);
 
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

    // Delete from Starting Postion
    private static Node deleteHeadFromFirst(Node head)
    {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    // Delete from the Last / Tail
    private static Node deleteHeadFromLast(Node head)
    {
        if(head == null || head.next == null) return null;
        Node temp = head;

        while(temp.next.next != null)
        {
            temp = temp.next;
        } 
        temp.next = null;
        return head;
    }

    // Delete from Given Position
    private static Node deleteFromPosition(Node head, int k)
    {
        if(head == null) return head;
 
        // 1. Case What if K is 1 then need to remove head.
        if(k == 1)
        {
            Node temp =  head;
            temp = temp.next; 
            return temp;
        }  

        int count = 0;
        Node prev = null;
        Node temp = head;

        while(temp != null)
        {
            count++;
            if(count == k)
            { 
                prev.next = prev.next.next;
                break;
            } 
            prev = temp;
            temp = temp.next;
        }  
        return head;
    }

    // Delete Element 
    private static Node deleteElement(Node head, int element)
    {
        if(head == null) return head;

        if(head.data == element)
        {
            Node temp = head;
            temp = temp.next;
            return head;
        }

        Node prev = null;
        Node temp = head;

        while(temp != null)
        {
            if(temp.data == element)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}

