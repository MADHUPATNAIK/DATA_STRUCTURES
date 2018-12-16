/*
Problem: Given an array arr[] of n elements, write a function to search a given element x in arr[].

Examples :

Input : arr[] = {10, 20, 80, 30, 60, 50,
                     110, 100, 130, 170}
          x = 110;
Output : 6
Element x is present at index 6

Input : arr[] = {10, 20, 80, 30, 60, 50,
                     110, 100, 130, 170}
           x = 175;
Output : -1
Element x is not present in arr[].


Iterative Approach:
*/

#include<stdio.h>

int linearSearch(int arr[], int size, int searchElement){
    int i;
    for(i=0; i<size; i++){
        if(arr[i] == searchElement){
            return i;
        }
    }
    return -1;
}

int main(){
    int size,i;
    int indexOfSearchElement;
    printf("Enter the length of the list: ");
    scanf("%d",&size);
    int arr[size];
    printf("Enter Array elements: ");
    for(i=0;i<size; i++){
        scanf("%d",&arr[i]);
    }
    int searchElement;
    printf("\nEnter the element you want to search for: ");
    scanf("%d",&searchElement);
    indexOfSearchElement = linearSearch(arr, size, searchElement);
    if(indexOfSearchElement == -1) printf("Element %d is not present in arr[]",searchElement);
    else printf("Element %d is present at index %d",searchElement,indexOfSearchElement);
    return 0;
}
