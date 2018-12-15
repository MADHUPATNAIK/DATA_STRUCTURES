/* Singly Linked List */ 

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insertAtBeginning(){
    struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
    printf("\nEnter the value:");
    scanf("%d",&temp->data);
    temp->next = head;
    head = temp;
    printf("Complete: Insertion at begin");
}

void insertAfterAValue(){
    int val;
    struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
    struct Node *ptr = head;
    printf("\nEnter the value of the new node:");
    scanf("%d",&temp->data);
    printf("\n Enter the node after which the new node should follow: ");
    scanf("%d",&val);
    if(head == NULL){
        printf("\nList is empty"); return;
    }
    while(ptr->next != NULL){
        if(ptr->data == val){
            temp->next = ptr->next;
            ptr->next = temp;
            printf("\nComplete: Insertion after the required node");
            return;
        }
        ptr = ptr->next;
    }
    printf("\nFailed: Could not find the Node in the list");
}

void insertAtEnd(){
    struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
    printf("\nEnter the value of the new node: ");
    scanf("%d",&temp->data);
    temp->next = NULL;
    struct Node *ptr = head;
    while(ptr->next != NULL){
        ptr = ptr->next;
    }
    ptr->next = temp;
    printf("\n Complete: Insertion at the end.") ;
}

void FindAValue(){
    int n;
    printf("\n Enter the element value: ");
    scanf("%d",&n);
    struct  Node *ptr = head;
    if(head == NULL){
        printf("\nList is empty");
        return;
    }
    while(ptr!=NULL){
        if(ptr->data == n){
            printf("\nComplete: Found the element in the list");
            return;
        }
        ptr = ptr->next;
    }
    printf("\nFailed: Element does not exist in the list");
}

void removeFromBeginning(){
    struct Node *ptr = head;
    if(head == NULL){
        printf("Failed: Empty list..Delete failed");
        return;
    }
    ptr = ptr->next;
    head = ptr;
    printf("\nComplete: Deletion from the beginning.");
}

void removeANode(){
    int n;
    if(head ==  NULL){
        printf("\nFailed: List empty");
        return;
    }
    printf("\n Enter the node value to be deleted: ");
    scanf("%d",&n);
    struct Node *ptr = head;
    while(ptr->next != NULL){
        if((ptr->next)->data == n){
            ptr->next = (ptr->next)->next;
            printf("\nComplete: Node deleted");
            return;
        }
        ptr = ptr->next;
    }
    printf("\nFailed: Could not find the element to delete.");
}

void removeFromEnd(){
    struct Node *ptr = head;
    if(head ==  NULL){
        printf("\nFailed: List empty");
        return;
    }
    while(ptr!= NULL){
        if(ptr->next->next == NULL){
            ptr->next = NULL;
            printf("\n Complete: Deletion at the end");
            return;
        }
        ptr = ptr->next;
    }
    printf("\nFailed: Could not delete.");
}

void printAllElements(){
    struct Node *ptr = head;
    printf("LIST ELEMENTS : \n");
    while(ptr != NULL){
        printf("%d\n",ptr->data);
        ptr = ptr->next;
    }
}

int main(){
    char ch;
    int n;
    do{
        printf("Choose from the following operations:\n");
        printf("1 : Insert at the beginning of the list\n");
        printf("2 : insert after a value in the list\n");
        printf("3 : Insert at the end of the list\n");
        printf("4 : Search for a particular element in the list\n");
        printf("5 : Remove an element from the beginning of  the list\n");
        printf("6 : Remove after a particular value in the list\n");
        printf("7 : Remove from the end of the list\n");
        printf("8 : Print all the list elements\n");
        printf("9 : Exit\n");
        scanf("%d",&n);
        switch(n){
            case 1: insertAtBeginning(); break;
            case 2: insertAfterAValue(); break;
            case 3: insertAtEnd(); break;
            case 4: FindAValue(); break;
            case 5: removeFromBeginning(); break;
            case 6: removeANode(); break;
            case 7: removeFromEnd(); break;
            case 8: printAllElements(); break;
            case 9: exit(0);
            default: printf("Invalid input"); break;
        }
        printf("\nDo you wish to continue: (y/n)");
        scanf(" %c",&ch);
    }while(ch == 'y' || ch == 'Y');
    return 0;
}
