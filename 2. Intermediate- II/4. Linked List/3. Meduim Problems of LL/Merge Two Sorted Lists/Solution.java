class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }
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

        // Merge Two Sorted List
        int[] list1 = {1,2,4};
        int[] list2 = {1,3,4};
        System.out.println("List 1");
        Node h1 = convertArrayToLL(list1); 
        printLinkedList(h1);
        System.out.println();
        System.out.println();

        System.out.println("List 2");
        Node h2 = convertArrayToLL(list2); 
        printLinkedList(h2);
        System.out.println();
        System.out.println();
 
        System.out.println("Merge Two Sorted List");
        Node newLL = mergeTwoSortedList(h1,h2); 
        printLinkedList(newLL);
        System.out.println();
        System.out.println();
 
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

    // Merge Two Sorted List
    private static Node mergeTwoSortedList(Node list1, Node list2)
    {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        Node t1 = list1;
        Node t2 = list2;

        while(t1 != null && t2 != null)
        {
            if(t1.data < t2.data)
            {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else
            {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null) 
        {
            temp.next = t1;
            temp = t1;
            t1 = t1.next;
        }

        if(t2 != null) 
        {
            temp.next = t2;
            temp = t2;
            t2 = t2.next;
        } 
        return dummyNode.next;
    }
 
}

