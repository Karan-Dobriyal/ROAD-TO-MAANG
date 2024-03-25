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

        // Deletion of Doubly Linked List.

        // 1. Delete at Head. 
        Node LL1 = convertArrayToDLL(arr);
        Node newHead = deleteHeadFromFirst(LL1); 
        System.out.println();
        System.out.println();
        System.out.println("Delete From Head");
        printLinkedList(newHead);


        // 2. Delete the Node.
        //Node LL2 = convertArrayToDLL(arr); 
        deleteNode(dummyHead.next); 
        System.out.println();
        System.out.println();
        System.out.println("Delete Node ");
        printLinkedList(dummyHead);

        // 3. Delete at given Position.
        Node LL3 = convertArrayToDLL(arr);
        int key = 2;
        Node newLL = deleteFromPostion(LL3,key); 
        System.out.println();
        System.out.println();
        System.out.println("Delete From Postion " + key);
        printLinkedList(newLL);
        
        // 4. Delete at Last.
        Node LL4 = convertArrayToDLL(arr);
        Node newTail = deleteFromLast(LL4); 
        System.out.println();
        System.out.println();
        System.out.println("Delete From Last");
        printLinkedList(newTail);
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

    // Delete at Head
    private static Node deleteHeadFromFirst(Node head)
    {
        if(head == null || head.next == null) return null;

        Node prev = head; 
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    } 

    // Delete at Last
    private static Node deleteFromLast(Node head)
    {
        if(head == null || head.next == null) return null;
        Node tail = head;

        while(tail.next != null)
        {
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    } 

    // Delete from Position
    private static Node deleteFromPostion(Node head, int key)
    {
        if(head == null || head.next == null) return null;

        Node KNode = head;
        int count = 0;
        while(KNode != null)
        {
            count++;
            if(count == key) break; 
            KNode = KNode.next;
        }
        Node prev = KNode.prev;
        Node front = KNode.next;

        if(prev == null && front == null) return null;  
        else if(prev == null) return deleteHeadFromFirst(head);
        else if(front == null) return deleteFromLast(head);

        prev.next = front;
        front.prev = prev;
        KNode.next = null;
        KNode.prev = null;
        return head;
    }

    // Delete from Position
    private static void deleteNode(Node temp)
    {  
        Node prev = temp.prev;
        Node front = temp.next;

        if(front == null)
        {
            prev.next = null;
            temp.prev = null;
            return;
        }
        prev.next = front;
        front.prev = prev;

        temp.next = temp.prev = null; 
    } 
}
 
