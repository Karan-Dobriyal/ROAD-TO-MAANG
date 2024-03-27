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
        int[] arr = {1,2};
        Node head = convertArrayToLL(arr); 
        Node dummyHead = head; 
        System.out.println("Original Linked List");
        printLinkedList(dummyHead);
        System.out.println();
        System.out.println();

        // Check Linked List is Plaindrome or not
        Node inputList = convertArrayToLL(arr); 
        System.out.println("is Linked List Plaindrome?");
        boolean isPlandrome = isLinkedListPlaindrome(inputList); 
        System.out.println(isPlandrome);
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

    // Is Linked List Plaindrome
    public static boolean isLinkedListPlaindrome(Node head)
    {
        if(head == null || head.next == null) return true;

        // 1. Find the cliff or middle.
        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the Linked List.
        Node newHead = reverseLinkedList(slow.next);

        // 3. Compare the Linked List
        Node first = head;
        Node second = newHead;

        while(second != null)
        {
            if(first.data != second.data)
            {
                reverseLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedList(newHead);
        return true;
    }

    // Reverse Linked List
    private static Node reverseLinkedList(Node head)
    {
        if(head == null || head.next == null) return head;

        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    
}

