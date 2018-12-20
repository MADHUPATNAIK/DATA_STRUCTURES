#include<stdio.h>

int* findMin(int arr[], int n, int start){
    int mini[2],i;
    mini[0] = arr[start];
    mini[1] = start;
    for(i=start+1; i<n; i++){
        if(arr[i] < mini[0]){
            mini[0] = arr[i];
            mini[1] = i;
        }
    }
    return mini;
}

void printArray(int arr[], int n){
    int i;
    printf("\nAfter Sorting the array elements are:  \n");
    for(i=0; i<n; i++){
        printf("%d\n",arr[i]);
    }
}

void selectionSort(int arr[], int n){
    int i = 0;
    int *mini;
    for(; i<n-1; i++){
        mini = findMin(arr, n,i);
        if(i == *(mini+1)) continue;
        int temp = arr[i];
        arr[i] = *(mini+0);
        arr[*(mini+1)] = temp;
    }
    printArray(arr,n);
}

int main()
{
    int n,i;
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int arr[n];
    printf("\n Enter the array elements: ");
    for(i=0; i<n; i++){
        scanf("%d",&arr[i]);
    }
    selectionSort(arr, n);
    return 0;
}
