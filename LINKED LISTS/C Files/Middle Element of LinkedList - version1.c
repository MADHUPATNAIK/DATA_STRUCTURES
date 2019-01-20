/*
Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2.
If there are even nodes, then there would be two middle nodes, we need to print second middle element. 
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
	int count = 0;
    struct Node *ptr = head;
    if(head == NULL) {
        printf("Empty List\n");
        return;
    }
    else{
        if(n%2 == 0)
            while(ptr != NULL){
                count+=1;
				if(count == n/2){ printf("Middle Element is %d\n",(ptr->next)->data);	return;}
				ptr = ptr->next;
			}
        else{
			while(ptr != NULL){
                count+=1;
				if(count == n/2+1){ printf("Middle Element is %d\n",ptr->data);	return;}
				ptr = ptr->next;
			}
        }
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
