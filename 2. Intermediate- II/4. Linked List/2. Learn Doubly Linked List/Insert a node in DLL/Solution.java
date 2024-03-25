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

        // Inserstion of Doubly Linked List.

        // 1. Insert at Head. 
        Node LL1 = convertArrayToDLL(arr);
        Node newHead = insertHeadFirst(LL1,10); 
        System.out.println();
        System.out.println();
        System.out.println("Insert at Head");
        printLinkedList(newHead);


        // 2. Insert the Node.
        Node LL2 = convertArrayToDLL(arr);
        insertBeforeNode(LL2.next.next,45); 
        System.out.println();
        System.out.println();
        System.out.println("Insert Before Node");
        printLinkedList(newHead);

        // 3. Insert before Position.
        Node LL3 = convertArrayToDLL(arr);
        Node newLL3 = insertBeforePosition(LL3,70,4); 
        System.out.println();
        System.out.println();
        System.out.println("Insert at Before Position");
        printLinkedList(newLL3);
        
        // 4. Insert before Last.
        Node LL4 = convertArrayToDLL(arr);
        Node newLL4 = insertBeforeLast(LL4,100); 
        System.out.println();
        System.out.println();
        System.out.println("Insert at Before Last");
        printLinkedList(newLL4);

        
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

    // Insert at Head
    private static Node insertHeadFirst(Node head, int val)
     {
        Node newHead = new Node(val,head,null);
        head.prev = newHead;
        return newHead;
     }

    // Insert Before the Last
    private static Node insertBeforeLast(Node head, int val)
    {
        if(head.next == null) 
        {
            return insertHeadFirst(head, val);
        }
        Node tail = head;
        while(tail.next != null) tail = tail.next;

        Node prev = tail.prev;
        Node newNode = new Node(val,tail,prev);
        prev.next = newNode;
        tail.prev = newNode;
        return head;
    }

    // Insert Before Position
    private static Node insertBeforePosition(Node head, int val, int pos)
    {
        if(pos == 1) return insertHeadFirst(head, val);
        Node tail = head;
        int count = 0;
        while(tail.next != null)
        {
            count++;
            if(count == pos) break;
            tail = tail.next;
        }

        Node prev = tail.prev;
        Node newNode = new Node(val,tail,prev);
        prev.next = newNode;
        tail.prev = newNode;
        return head;

    }

    // Insert Before Node 
    private static void insertBeforeNode(Node head, int val)
    {
        Node prev = head.prev;
        Node newNode = new Node(val,head,prev);
        prev.next = newNode;
        head.prev = newNode;
    }
}
 
