import java.util.Scanner;

class LLStack {
    private static Scanner sc = new Scanner(System.in);
    private Node head;

    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
        }
    }

    private static void push(LLStack ll){
        System.out.println("Enter the new value: ");
        Node currentNode = new Node(sc.nextInt());
        if(ll.head == null){
            ll.head = currentNode;
            return;
        }
        currentNode.next = ll.head;
        ll.head = currentNode;
    }

    private static void pop(LLStack ll){
        if(ll.head == null){
            System.out.println("Empty List");
            return;
        }
        ll.head = ll.head.next;
    }

    private static void printList(LLStack ll){
        System.out.println("List elements are: ");
        Node traverse = ll.head;
        while(traverse != null){
            System.out.println(traverse.data);
            traverse = traverse.next;
        }
     }

    private static void searchList(LLStack ll){
        Node traverse = ll.head;
        System.out.println("Enter the element you want to search for: ");
        int searchElement = sc.nextInt();
        while(traverse != null){
            if(traverse.data == searchElement){
                System.out.println("Element "+traverse.data+" is present in the list");
                return;
            }
            traverse = traverse.next;
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args){
        LLStack ll = new LLStack();
        String str;
        do{
            System.out.println("1. Insert into stack");
            System.out.println("2. Pop from stack");
            System.out.println("3. Print stack elements");
            System.out.println("4. Search for a particular element in List");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1: push(ll); break;
                case 2: pop(ll); break;
                case 3: printList(ll); break;
                case 4: searchList(ll); break;
                default: System.out.println("Invalid choice"); break;
            }
            System.out.println("Do you wish to continue? (y/n)");
            str = sc.next();
        }while(str.equalsIgnoreCase("y"));
    }
}
