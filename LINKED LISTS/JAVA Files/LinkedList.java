import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

public class LinkedList{

    static Scanner sc = new Scanner(System.in);
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
        }
    }

    public static void insertAtBegin(LinkedList list){
        System.out.println("Enter a value to be inserted: ");
        Node insertNode = new Node(sc.nextInt());

        if(list.head!=null){
            System.out.println("The list is not empty");
            insertNode.next = list.head;
        }
        list.head = insertNode;
    }

    public static void insertAtEnd(LinkedList list){
        System.out.println("Value to be inserted: ");
        Node currentNode = new Node(sc.nextInt());
        Node traveller = list.head;
        if(list.head == null){
            System.out.println("Looks like the list is empty");
            list.head = currentNode;
            return;
        }
        while(traveller.next != null){
            traveller = traveller.next;
        }
        traveller.next = currentNode;
    }

    public static void insertAfterNode(LinkedList list){
        System.out.println("Enter the value to be inserted");
        Node currentNode = new Node(sc.nextInt());
        System.out.println("Enter the node value after which the node should be inserted: ");
        int value = sc.nextInt();
        Node traveller = list.head;
        while(traveller.data != value){
            if(traveller.next == null){
                System.out.println("The required element is not in the list");
                return;
            }
            traveller = traveller.next;
        }
        currentNode.next = traveller.next;
        traveller.next = currentNode;
    }

    public static void delFirstNode(LinkedList list){
        Node traverse = list.head.next;
        list.head = traverse;
        System.out.println("Deletion of first Node is complete");
    }

    public static void delLastNode(LinkedList list){
        Node traverse = list.head;
        while(traverse.next.next != null){
            traverse = traverse.next;
        }
        traverse.next = null;
        System.out.println("Deletion of the last node complete");
    }

    public static void delParticularNode(LinkedList list){
        System.out.println("Enter the value you want to delete ");
        int val = sc.nextInt();
        Node traverse = list.head;
        while(traverse.next.data != val){
            traverse = traverse.next;
        }
        traverse.next = traverse.next.next;
        System.out.println("Deletion of the required node is complete");
    }

    public static void printList(LinkedList list){
        System.out.println("The list elements are :");
        Node pointerNode = list.head;
        while(pointerNode != null){
            System.out.println(pointerNode.data);
            pointerNode = pointerNode.next;
        }
    }

    public static void main(String[] args) throws IOException {
        int choice = 0;
        String c = "n";
        LinkedList list = new LinkedList();
        System.out.println("Your choice is: "+choice);
        do{
            System.out.println("1. Insert in the beginning of the list");
            System.out.println("2. Insert in the end of the list1");
            System.out.println("3. Insert after a particular node in the list");
            System.out.println("4. Delete the first node");
            System.out.println("5. Delete the last node");
            System.out.println("6. Delete the node based on particular value");
            System.out.println("7. Print the list");
            System.out.println("Enter choice : ");
            choice = sc.nextInt();
            switch(choice){
                case 1: insertAtBegin(list); break;
                case 2: insertAtEnd(list); break;
                case 3: insertAfterNode(list); break;
                case 4: delFirstNode(list); break;
                case 5: delLastNode(list); break;
                case 6: delParticularNode(list); break;
                case 7: printList(list); break;
                default: System.out.println("Invalid choice"); break;
            }
            System.out.println("Do you wish to continue: (y/n)?");
            c = sc.next();
        }while(c.compareTo("y") == 0 || c.compareTo("Y") == 0);
    }
}