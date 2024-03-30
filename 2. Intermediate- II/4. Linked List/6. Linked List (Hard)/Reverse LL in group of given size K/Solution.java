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

        //  Reverse LL in group of given size K
        Node inputList = convertArrayToLL(arr); 
        System.out.println("Reverse LL in Group of K, k = 2");
        Node revLLOfK = revLLOfK(inputList,2); 
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

    // Reverse LL in Group of K
    private static Node revLLOfK(Node head, int k)
    {
        // Initialize a temporary
        // node to traverse the list
        Node temp = head;
        
        // Initialize a pointer to track the
        // last node of the previous group
        Node prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            
            // Get the Kth node of the current group
            Node kThNode = getKthNode(temp, k);
            
            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {
               
                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            // Store the next node
            // after the Kth node
            Node nextNode = kThNode.next;
            
            // Disconnect the Kth node
            // to prepare for reversal
            kThNode.next = null;
            
            // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(temp);
            
             // Adjust the head if the reversal
            // starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }
            
            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the
        // modified linked list
        return head;
    }

    private static Node  reverseLinkedList(Node head)
    {
       Node temp = head;
       Node prev = null;

       while(temp != null)
       {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
       }
       return prev;
    }
    private static Node getKthNode(Node temp, int key)
    {
        key -= 1;
        while(temp != null && key >0)
        {
            key--;
            temp = temp.next;
        }
        return temp;
    }
}

