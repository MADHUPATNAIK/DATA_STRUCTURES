import java.util.Scanner;

public class CircularLinkedList {
    private static Scanner sc = new Scanner(System.in);
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
        }
    }

    private static void insertAtBegin(CircularLinkedList clist){
        System.out.println("Enter a value to be inserted: ");
        Node insertNode = new Node(sc.nextInt());

        if(clist.head!=null){
            System.out.println("The list is not empty");
            insertNode.next = clist.head;
        }
        clist.head = insertNode;
    }

    private static void insertAtEnd(CircularLinkedList clist){
        System.out.println("Value to be inserted: ");
        Node currentNode = new Node(sc.nextInt());
        currentNode.next = clist.head;
        Node traveller = clist.head;
        if(clist.head == null){
            System.out.println("Looks like the list is empty");
            clist.head = currentNode;
            return;
        }
        while(traveller.next != null){
            traveller = traveller.next;
        }
        traveller.next = currentNode;
    }

    private static void insertAfterNode(CircularLinkedList clist){
        System.out.println("Enter the value to be inserted");
        Node currentNode = new Node(sc.nextInt());
        System.out.println("Enter the node value after which the node should be inserted: ");
        int value = sc.nextInt();
        Node traverse = clist.head;
        while(traverse.data != value){
            if(traverse.next == null){
                System.out.println("The required element is not in the list");
                return;
            }
            traverse = traverse.next;
        }
        currentNode.next = traverse.next;
        traverse.next = currentNode;
    }

    private static void delFirstNode(CircularLinkedList clist){
        Node traverse = clist.head.next;
        clist.head = traverse;
        System.out.println("Deletion of first Node is complete");
    }

    private static void delLastNode(CircularLinkedList clist){
        Node traverse = clist.head;
        while(traverse.next.next != null){
            traverse = traverse.next;
        }
        traverse.next = null;
        System.out.println("Deletion of the last node complete");
    }

    private static void delParticularNode(CircularLinkedList clist){
        System.out.println("Enter the value you want to delete ");
        int val = sc.nextInt();
        Node traverse = clist.head;
        while(traverse.next.data != val){
            traverse = traverse.next;
        }
        traverse.next = traverse.next.next;
        System.out.println("Deletion of the required node is complete");
    }

    private static void printList(CircularLinkedList clist){
        System.out.println("The list elements are :");
        Node pointerNode = clist.head;
        while(pointerNode != null){
            System.out.println(pointerNode.data);
            pointerNode = pointerNode.next;
        }
    }

    public static void main(String[] args){
        int choice = 0;
        String c = "n";
        CircularLinkedList list = new CircularLinkedList();
        System.out.println("Your choice is: "+choice);
        do{
            System.out.println("1. Insert in the beginning of the list");
            System.out.println("2. Insert in the end of the list");
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
