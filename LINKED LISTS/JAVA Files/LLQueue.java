import java.util.Scanner;

public class LLQueue {
    private static Scanner sc = new Scanner(System.in);
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
        }
    }

    private static boolean isListEmpty(LLQueue llq){
        if(llq.head == null){
            System.out.println("Empty list");
            return true;
        }
        return false;
    }

    private static void push(LLQueue llq){
        System.out.println("Enter the element you want to insert into queue");
        Node currentNode = new Node(sc.nextInt());
        if(llq.head == null){
            llq.head = currentNode;
            return;
        }
        Node traverse = llq.head;
        while(traverse.next != null) traverse = traverse.next;
        traverse.next = currentNode;
    }

    private static void pop(LLQueue llq){
        if (isListEmpty(llq)) return;
        llq.head = llq.head.next;
    }

    private static void printList(LLQueue llq){
        if (isListEmpty(llq)) return;
        Node traverse = llq.head;
        while(traverse != null){
            System.out.println(traverse.data);
            traverse = traverse.next;
        }
    }

    private static void searchList(LLQueue llq){
        if (isListEmpty(llq)) return;
        Node traverse = llq.head;
        System.out.println("Enter the element you want to search for: ");
        int val = sc.nextInt();
        while(traverse.next != null){
            if(traverse.data == val){
                System.out.println("Element "+traverse.data+" is present in the Queue");
                return;
            }
            traverse = traverse.next;
        }
        System.out.println("Element is not in the Queue");
    }

    public static void main(String[] args){
        LLQueue llq = new LLQueue();
        String str;
        do{
            System.out.println("1. Insert into queue");
            System.out.println("2. Pop from queue");
            System.out.println("3. Print stack queue");
            System.out.println("4. Search for a particular element in Queue");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1: push(llq); break;
                case 2: pop(llq); break;
                case 3: printList(llq); break;
                case 4: searchList(llq); break;
                default: System.out.println("Invalid choice"); break;
            }
            System.out.println("Do you wish to continue? (y/n)");
            str = sc.next();
        }while(str.equalsIgnoreCase("y"));
    }
}
