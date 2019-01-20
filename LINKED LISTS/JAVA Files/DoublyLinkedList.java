import java.util.Scanner;

public class DoublyLinkedList {
    private static Scanner sc = new Scanner(System.in);
    Node head;
    Node tail;

    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int value){
            data = value;
        }
    }

    private static void insertAtBegin(DoublyLinkedList dlist){
        System.out.println("Enter the value to insert in node");
        Node currentNode = new Node(sc.nextInt());
        if(dlist.head == null){
            dlist.head = currentNode;
            dlist.tail = currentNode;
            return;
        }
        System.out.println("Reached here");
        currentNode.next = dlist.head;
        dlist.head.prev = currentNode;
        dlist.head = currentNode;
    }

    private static void insertAtEnd(DoublyLinkedList dlist){
        System.out.println("Enter the value: ");
        Node currentNode = new Node(sc.nextInt());
        if(dlist.head == null){
            dlist.head = currentNode;
            dlist.tail = currentNode;
            return;
        }
        Node traverse = dlist.head;
        while(traverse.next != null){
            traverse = traverse.next;
        }
        currentNode.prev = traverse;
        traverse.next = currentNode;
        dlist.tail = currentNode;
    }

    private static void insertAfterNode(DoublyLinkedList dlist){
        System.out.println("Enter the value to be inserted: ");
        Node currentNode = new Node(sc.nextInt());
        System.out.println("Enter the value after which the new node is to be inserted: ");
        int val = sc.nextInt();
        if(dlist.head == null && dlist.tail == null){
            dlist.head = currentNode;
            dlist.tail = currentNode;
            return;
        }
        Node traverse = dlist.head;
        while(traverse.data != val){
            if(traverse.next == null){
                System.out.println("Value doesn't exist in the list");
                return;
            }
            traverse = traverse.next;
        }
        traverse.next.prev = currentNode;
        currentNode.next = traverse.next;
        currentNode.prev = traverse;
        traverse.next = currentNode;
    }

    private static void insertBeforeNode(DoublyLinkedList dlist){
        System.out.println("Enter the new value: ");
        Node currentNode = new Node(sc.nextInt());
        System.out.println("Enter the value before which the new value should be inserted: ");
        int val = sc.nextInt();
        if(dlist.head == null && dlist.tail == null){
            dlist.head = currentNode;
            dlist.tail = currentNode;
            return;
        }
        Node traverse = dlist.head;
        while(traverse.data != val){
            if(traverse.next == null){
                System.out.println("Value doesn't exist in the list");
                return;
            }
            traverse = traverse.next;
        }
        traverse.prev.next = currentNode;
        currentNode.prev = traverse.prev;
        traverse.prev = currentNode;
        currentNode.next = traverse;
    }

    private static void delFirstNode(DoublyLinkedList dlist){
        if(dlist.head == null){
            System.out.println("Empty list");
            return;
        }
        dlist.head.next.prev = null;
        System.out.println("Value pointing to the 2nd node from head"+dlist.head.next.data);
        dlist.head = dlist.head.next;
    }

    private static void delLastNode(DoublyLinkedList dlist){
        if(dlist.tail == null){
            System.out.println("Nothing to delete");
            return;
        }
        dlist.tail = dlist.tail.prev;
        dlist.tail.next = null;
    }

    private static void delParticularNode(DoublyLinkedList dlist){
        Node traverse = dlist.head;
        System.out.println("Enter the value to be deleted from the list");
        int val = sc.nextInt();
        while(traverse.data != val){
            if(traverse.next == null){
                System.out.println("Value doesn't exist in the list");
                return;
            }
            traverse = traverse.next;
        }
        traverse.prev.next = traverse.next;
        traverse.next.prev = traverse.prev;
    }

    private static void printListFront(DoublyLinkedList dlist){
        Node traverse = dlist.head;
        while(traverse != null){
            System.out.println(traverse.data);
            traverse = traverse.next;
        }
    }

    private static void printListReverse(DoublyLinkedList dlist){
        Node traverse = dlist.tail;
        while(traverse != null){
            System.out.println(traverse.data);
            traverse = traverse.prev;
        }
    }

    public static void main(String[] args){
        int choice = 0;
        String c = "n";
        DoublyLinkedList dlist = new DoublyLinkedList();
        System.out.println("Your choice is: "+choice);
        do{
            System.out.println("1. Insert in the beginning of the list");
            System.out.println("2. Insert in the end of the list");
            System.out.println("3. Insert after a particular node in the list");
            System.out.println("4. Insert before a particular node in the list");
            System.out.println("5. Delete the first node");
            System.out.println("6. Delete the last node");
            System.out.println("7. Delete the node based on particular value");
            System.out.println("8. Print from the beginning of the list");
            System.out.println("9. Print the list in the reverse order");
            System.out.println("Enter choice : ");
            choice = sc.nextInt();
            switch(choice){
                case 1: insertAtBegin(dlist); break;
                case 2: insertAtEnd(dlist); break;
                case 3: insertAfterNode(dlist); break;
                case 4: insertBeforeNode(dlist); break;
                case 5: delFirstNode(dlist); break;
                case 6: delLastNode(dlist); break;
                case 7: delParticularNode(dlist); break;
                case 8: printListFront(dlist); break;
                case 9: printListReverse(dlist); break;
                default: System.out.println("Invalid choice"); break;
            }
            System.out.println("Do you wish to continue: (y/n)?");
            c = sc.next();
        }while(c.compareTo("y") == 0 || c.compareTo("Y") == 0);
    }
}
