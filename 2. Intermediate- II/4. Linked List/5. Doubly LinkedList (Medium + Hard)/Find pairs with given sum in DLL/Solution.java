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
        int[] arr = {1,2,3,4,9};
        Node head = convertArrayToDLL(arr);
        Node dummyHead = head;
        printLinkedList(dummyHead);  

        // 1. Find Pairs
        Node LL1 = convertArrayToDLL(arr);
        ArrayList<ArrayList<Integer>>  newLst = findPairs(LL1,5); 
        System.out.println();
        System.out.println();
        System.out.println("Find Pairs");
        for (ArrayList<Integer> innerList : newLst) {
            // Iterate over each inner ArrayList
            for (Integer number : innerList) {
                System.out.print(number + " ");
            }
            System.out.println(); // Print a new line after each inner ArrayList
        }
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

    // Find Pairs
    public static ArrayList<ArrayList<Integer>> findPairs(Node head, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        } 
        Node front = head;
        while (front.data < tail.data) {
            if (front.data + tail.data < k) {
                front = front.next;
            } else if (front.data + tail.data > k) {
                tail = tail.prev;
            } else {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(front.data);
                pair.add(tail.data);
                ans.add(pair);
                front = front.next;
                tail = tail.prev;
            }
        }
        return ans;
    } 
}
 
