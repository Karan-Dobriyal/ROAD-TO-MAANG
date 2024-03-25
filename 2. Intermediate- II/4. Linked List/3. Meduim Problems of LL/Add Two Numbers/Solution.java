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
        int[] arr1 = {9,9,9,9,9,9,9};
        Node l1 = convertArrayToLL(arr1); 
        System.out.println("List 1");
        printLinkedList(l1);   

        int[] arr2 = {9,9,9,9};
        Node l2 = convertArrayToLL(arr2); 
        System.out.println();
        System.out.println();
        System.out.println("List 2");
        printLinkedList(l2);  

        Node  sumList = addTwoNumbers(l1,l2);
        System.out.println();
        System.out.println();
        System.out.println("Sum List");
        printLinkedList(sumList);  
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

    // Add two Numbers
    public static Node addTwoNumbers(Node l1, Node l2) 
    {
        Node t1 = l1;
        Node t2 = l2;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        int carry = 0; 

        while(t1 != null || t2 != null || carry == 1)
        {   
            int sum = carry;
            if(t1 != null) sum  =  sum +  t1.data;
            if(t2 != null) sum = sum +  t2.data;

            Node newNode = new Node(sum%10);
            carry = sum / 10;
            current.next = newNode;
            current = current.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
 
        return dummyNode.next;
    }
} 
 
