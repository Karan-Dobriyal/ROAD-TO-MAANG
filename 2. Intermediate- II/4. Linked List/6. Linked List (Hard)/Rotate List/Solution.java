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
        Node dummyHead = head; 
        System.out.println("Original Linked List");
        printLinkedList(dummyHead);
        System.out.println();
        System.out.println();

        //  Rotate Linked List
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Rotated List by 2");
        Node revLLOfK = rotate(inputList,2); 
        printLinkedList(revLLOfK);
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

    // Rotate Linked List
    public static Node rotate(Node head, int k) {
        if(head == null || head.next == null) return head;
        int len = 1;
        Node tail = head;

        while(tail.next != null)
        { 
            tail = tail.next;
            len+=1;
        }    

        if(k % len == 0) return head;
        k = k % len;
        tail.next = head;

        Node newNode = findKthNode(head, len-k); 
        head = newNode.next;
        newNode.next = null;
       return head;
    }

    private static Node  findKthNode(Node temp, int k)
    {
        int cnt = 1;
        while(temp != null)
        {
            if(cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }

}

