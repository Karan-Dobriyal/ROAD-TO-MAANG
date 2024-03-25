import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        sc.close();
        int[] arr = {1,2,3,4,5,6};
        Node head = convertArrayToLL(arr);
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

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
}

// Time Compleixty is O(N).
// Space Complecity is O(1).
