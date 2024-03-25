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

        // Inserstion in a Linked List.

        // 1. Insert the Head
        Node newHead = insertAtHead(dummyHead,0); 
        System.out.println();
        System.out.println();
        System.out.println("Insert At Head");
        printLinkedList(newHead);

        // 2. Insert the given element at specfic position
        int element = 20;
        Node newLL = insertAtSpecificPostion(dummyHead,element,5); 
        System.out.println();
        System.out.println();
        System.out.println("Insert At Specific Element " + element);
        printLinkedList(newLL);
         
        // 3. Insert the given Element before old Element 
        Node newLinkedList = insertAtBeforeElement(dummyHead,70,20); 
        System.out.println();
        System.out.println();
        System.out.println("Insert At Specific Element Before Old " + element);
        printLinkedList(newLinkedList);
        
        // 4. Insert at the End
        Node newTail = insertAtEnd(dummyHead,6); 
        System.out.println();
        System.out.println();
        System.out.println("Insert At Last");
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

    // Insert at the head
    private static Node insertAtHead(Node head, int element)
    {
        if(head == null)
        {
            Node newNode = new Node(element);
            return newNode;
        }
        Node newHead = new Node(element);
        newHead.next = head;
        return newHead;
    }

    // Insert at the Last
    private static Node insertAtEnd(Node head, int element)
    {
        if(head == null)
        {
            Node newNode = new Node(element);
            return newNode;
        }
        Node temp = head;
        Node newTail = new Node(element);
        while(temp.next != null)
        {       
            temp = temp.next;
        }
        temp.next = newTail; 
        return head;
    } 

    // Insert at Specfic Position
    private static Node insertAtSpecificPostion(Node head, int element, int position)
    {
        if(head == null)
        {
            return new Node(element);
        } 
        if(position == 1)
        {
            Node newNode = new Node(element);
            newNode.next = head;
            return newNode;
        }
        Node temp = head; 
        int count = 0;

        while(temp.next != null)
        {
            count++;
            if(count == position-1)
            {
                Node newNode = new Node(element); 
                newNode.next = temp.next;
                temp.next = newNode; 
                break;
            } 
            temp = temp.next; 
        }
        return head;
    }

    // Insert at Specfic Element before old element
    private static Node insertAtBeforeElement(Node head, int element, int val)
    {
        if(head == null)
        {
           return null;
        } 
        if(head.data == val)
        {
            Node newNode = new Node(element);
            newNode.next = head;
            return newNode;
        }
        Node temp = head;  
        while(temp.next != null)
        { 
            if(temp.next.data == val)
            {
                Node newNode = new Node(element); 
                newNode.next = temp.next;
                temp.next = newNode; 
                break;
            } 
            temp = temp.next; 
        }
        return head;
    } 
}

