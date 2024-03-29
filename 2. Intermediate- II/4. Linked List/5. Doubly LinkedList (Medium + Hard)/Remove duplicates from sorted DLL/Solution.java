import java.util.*;
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
        int[] arr = {1,2,2,2,3};
        Node head = convertArrayToDLL(arr);
        Node dummyHead = head;
        printLinkedList(dummyHead);  

        //   Remove Duplicates
        Node LL1 = convertArrayToDLL(arr);
        Node  newLst = removeDuplicates(LL1); 
        System.out.println();
        System.out.println();
        System.out.println("Remove Duplicates");
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

    //   Remove Duplicates
    public static Node removeDuplicates(Node head) {
        
        Node temp = head;

        while(temp != null && temp.next != null)
        {
            Node front = temp.next;

            while(front != null && front.data == temp.data)
            {
                front = front.next;
            }
            temp.next = front;
            if(front != null) front.prev = temp;
            temp = temp.next;
        }
        return head;
    } 
}
 
