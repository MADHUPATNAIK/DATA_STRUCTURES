/*
Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
When the fast pointer reaches end slow pointer will reach middle of the linked list.
*/

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insertAtBeginning(){
    struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter the value : \n");
    scanf("%d",&temp->data);
    temp->next = head;
    head = temp;
}

int countLength(struct Node *temp){
    if(temp == NULL) return 0;
    else return 1+countLength(temp->next);
}

void middleElement(){
    int n = countLength(head);
    struct Node *fast_ptr = head;
    struct Node *slow_ptr = head;
    if(head == NULL) {
        printf("Empty List\n");
        return;
    }
    else{
        while(fast_ptr->next != NULL && fast_ptr->next->next != NULL){
            fast_ptr = fast_ptr->next->next;
            slow_ptr = slow_ptr->next;
        }
        if(n%2!=0)printf("\n The middle element is %d \n", slow_ptr->data);
        else printf("\n The middle element is %d \n", (slow_ptr->next)->data);
    }
}

void printAllElements(){
    struct Node *temp = head;
    printf("\n LIST ELEMENTS: \n");
    while(temp != NULL){
        printf("%d\n",temp->data);
        temp = temp->next;
    }
}

int main(){
    char ch;
    int n, count;
    do{
        printf("Choose from the following operations:\n");
        printf("1 : Insert at the beginning of the list\n");
        printf("2 : Count the length of the list\n");
        printf("3 : Print the middle element of the list\n");
        printf("4 : Print all the list elements\n");
        printf("5 : Exit\n");
        scanf("%d",&n);
        switch(n){
            case 1: insertAtBeginning(); break;
            case 2: count = countLength(head); printf("Linked List length: %d",count); break;
            case 3: middleElement(); break;
            case 4: printAllElements(); break;
            case 5: exit(0);
            default: printf("Invalid input"); break;
        }
        printf("\nDo you wish to continue: (y/n)");
        scanf(" %c",&ch);
    }while(ch == 'y' || ch == 'Y');
    return 0;
    return 0;
}
