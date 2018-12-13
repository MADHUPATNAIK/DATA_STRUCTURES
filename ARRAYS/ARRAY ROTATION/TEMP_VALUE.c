#include <stdio.h>
#include <stdlib.h>


int* rotate(int arr[], int n){
    int i;
    int temp = arr[0];
    for(i=1; i<n; i++){
        arr[i-1] = arr[i];
    }
    arr[n-1] = temp;
    return arr;
}

int main()
{
    int t,n,d,i,j,k;
    scanf("%d",&t);
    int *ans;
    for(j=0; j<t; j++){
        scanf("%d",&n);
        int arr[n];
        for(i=0; i<n; i++){
            scanf("%d",&arr[i]);
        }
        scanf("%d",&d);
        for(k=0; k<d; k++){
            ans = rotate(arr,n);
        }
        for(i=0; i<n; i++){
            printf("%d\t",*(ans+i));
        }
    }
    return 0;
}
