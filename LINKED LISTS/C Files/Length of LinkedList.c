/* Iterative Technique : Finding length of the LinkedList */

#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insertAtBeginning(){
    struct Node *temp = (struct Node*)malloc(sizeof(struct Node));
    printf("Enter the value:");
    scanf("%d",&temp->data);
    temp->next = head;
    head = temp;
    printf("Insertion at the beginning of the list is complete");
}

int countLength(){
    int count = 0;
    struct Node *ptr = head;
    if(head == NULL) return 0;
    while(ptr != NULL){
        count+=1;
        ptr = ptr->next;
    }
    return count;
}

void printAllElements(){
    printf("\n\n List elements are:\n");
    struct Node *temp = head;
    while(temp != NULL){
        printf("%d\n",temp->data);
        temp = temp->next;
    }
}


int main()
{
    char ch;
    int n, count;
    do{
        printf("Choose from the following operations:\n");
        printf("1 : Insert at the beginning of the list\n");
        printf("2 : Count the length of the list\n");
        printf("3 : Print all the list elements\n");
        printf("4 : Exit\n");
        scanf("%d",&n);
        switch(n){
            case 1: insertAtBeginning(); break;
            case 2: count = countLength(); printf("Linked List length: %d",count); break;
            case 3: printAllElements(); break;
            case 4: exit(0);
            default: printf("Invalid input"); break;
        }
        printf("\nDo you wish to continue: (y/n)");
        scanf(" %c",&ch);
    }while(ch == 'y' || ch == 'Y');
    return 0;
}
