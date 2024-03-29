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
        int[] arr = {1,2,3,3,4,4,2,4,5,6,6,4};
        Node head = convertArrayToDLL(arr);
        Node dummyHead = head;
        printLinkedList(dummyHead);  

        // Delete Occurences
        Node LL1 = convertArrayToDLL(arr);
        Node newLst = deleteOccurence(LL1,4); 
        System.out.println();
        System.out.println();
        System.out.println("Delete Occuerences of 4");
        printLinkedList(newLst); 
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

    // Delete Occurences
    private static Node deleteOccurence(Node head, int key)
    {
        Node temp = head;

        while(temp != null)
        {
            if(temp.data == key)
            {
                if(temp == head) head = head.next;
                Node front = temp.next;
                Node prev = temp.prev;

                if(front != null) front.prev = prev;
                if(prev != null) prev.next = front; 
                temp = temp.next;
            }
            else
            {
                temp = temp.next;
            }
        }
        return head;
    } 
}
 
