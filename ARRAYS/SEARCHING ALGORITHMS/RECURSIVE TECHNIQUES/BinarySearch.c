/*
Binary Search

Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
A simple approach is to do linear search.The time complexity of above algorithm is O(n).
Another approach to perform the same task is using Binary Search.

Binary Search: Search a sorted array by repeatedly dividing the search interval in half.
Begin with an interval covering the whole array.
If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.

The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).

Recursive Approach:
*/

#include<stdio.h>

int binarySearch(int arr[], int leftIndex,int rightIndex, int searchElement){
    if(rightIndex >= leftIndex){
        int middleIndex = leftIndex+(rightIndex-leftIndex)/2;
        if(arr[middleIndex] == searchElement) return middleIndex;
        else if(arr[middleIndex] < searchElement) return  binarySearch(arr, middleIndex+1, rightIndex, searchElement);
        else return binarySearch(arr, leftIndex, middleIndex-1, searchElement);
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
    indexOfSearchElement = binarySearch(arr, 0, size-1, searchElement);
    if(indexOfSearchElement == -1) printf("Element %d is not present in arr[]",searchElement);
    else printf("Element %d is present at index %d",searchElement,indexOfSearchElement);
    return 0;
}
