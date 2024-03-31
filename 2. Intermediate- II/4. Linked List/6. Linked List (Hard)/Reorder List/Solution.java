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

        //  Reorder Linked List
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Reordered List");
        Node reOrder = reorder(inputList); 
        printLinkedList(reOrder);
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

    // Reordered List
    public static Node reorder(Node A) {
        Node h1 = A ;

        Node middle = findMiddle(A) ;

        Node h2 = middle.next ;

        middle.next = null ;

        h2 = Reverse_LinkedList(h2) ;

        while(h2 != null)
        {
            Node h1_next = h1.next ;
            Node h2_next = h2.next ;
            h1.next = h2 ;
            h2.next = h1_next ;
            h1 = h1_next ;
            h2 = h2_next ;
        }
        return A ;
    }
    public static  Node Reverse_LinkedList(Node head)
    {
        Node prevNode = null ;
        Node currNode = head ;

        while(currNode != null)
        {
            Node nextNode = currNode.next ;
            currNode.next = prevNode ;
            prevNode = currNode ;
            currNode = nextNode ;
        }

        return prevNode ;
    }
    public static Node findMiddle(Node head)
    {
        Node slow = head ;
        Node fast = head ;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next ;
            fast = fast.next.next ;
        }

        return slow ;
    }
 
}

