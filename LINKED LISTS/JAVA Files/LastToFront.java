//Java program to move the last node to the front of the list

package LinkedLists;
import java.util.Scanner;

public class LastToFront {
    static LinkedList llist = new LinkedList();
    private static void lastToFront(LinkedList llist){
        LinkedList.Node traverse = llist.head;
        LinkedList.Node lastNode = llist.head;
        while(traverse.next.next != null){
            traverse = traverse.next;
        }
        lastNode = traverse.next;
        traverse.next = null;
        lastNode.next = llist.head;
        llist.head = lastNode;
    }
    public static void main(String[] args) {
        System.out.println("Number of elements to be inserted");
        int n = llist.sc.nextInt();
        System.out.println("Adding elements at the back of the list:");
        for(int i =0; i<n; i++){
            llist.insertAtEnd(llist);
        }
        System.out.println("Printing the list elements: ");
        llist.printList(llist);
        System.out.println("Trying to move the element from last to first");
        lastToFront(llist);
        System.out.println("After moving the last element to the front: ");
        llist.printList(llist);
    }
}
