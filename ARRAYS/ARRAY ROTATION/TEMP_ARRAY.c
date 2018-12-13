#include <stdio.h>
#include <stdlib.h>


void rotate(int arr[], int n, int d){
    int arr1[d];
    int i,j;
    for(i=0; i<d; i++){
        arr1[i] = arr[i];
    }
    for(i=d,j=0;j<i && i<n;j++, i++){
        arr[j] = arr[i];
    }
    for(i=0, j=d+1; i<d && j<n; j++,i++){
        arr[j] = arr1[i];
    }
    for(i=0; i<n; i++){
        printf("%d\t",arr[i]);
    }
}

int main()
{
    int t,n,d,i,j;
    scanf("%d",&t);
    for(j=0; j<t; j++){
        scanf("%d",&n);
        int arr[n];
        for(i=0; i<n; i++){
            scanf("%d",&arr[i]);
        }
        scanf("%d",&d);
        rotate(arr,n,d);
    }
    return 0;
}
