/*
Program for n’th node from the end of a Linked List
Given a Linked List and a number n, write a function that returns the value at the n’th node from end of the Linked List.
Method (Use length of linked list)
1) Calculate the length of Linked List. Let the length be len.
2) Print the (len – n + 1)th node from the begining of the Linked List.
*/

package LinkedLists;

public class NthNodeFromEnd {
    static LinkedList llist = new LinkedList();

    public static int nthNodeFromLast(LinkedList llist, int nthNode){
        //Using lengths to find the nthNode from End
        LinkedList.Node findLen = llist.head;
        int count = 0;
        while(findLen.next != null){
            count++;
            findLen = findLen.next;
        }
        count+=1;
        System.out.println("Length of list: "+count);
        System.out.println(nthNode+" from end is "+(count-nthNode+1)+" from beginning");
        LinkedList.Node traverse = llist.head;
        for(int i=0; ; i++){
            if( i+1 == count-nthNode+1) return traverse.data;
            traverse = traverse.next;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Finding the nth node from the end of the list");
        String choice;
        do{
            llist.insertAtEnd(llist);
            System.out.println("Do you still wish to insert elements in the list? (y/n)");
            choice = llist.sc.next();
        }while(choice.compareTo("y") == 0 || choice.compareTo("Y") == 0);
        System.out.println("Enter the nth node you want to find from end: ");
        int nthNode = llist.sc.nextInt();
        System.out.println(nthNodeFromLast(llist, nthNode));
    }
}
