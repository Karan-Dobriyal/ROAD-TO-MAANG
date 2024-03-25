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
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr);
        Node temp = head; 
        int target = 3;
        boolean ans = false;
        while(temp != null)
        { 
            if(target == temp.data) ans = true;
            temp = temp.next; 
        } 
        System.out.print(ans);
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

