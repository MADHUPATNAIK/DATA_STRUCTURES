#include <stdio.h>
#include <stdlib.h>

int gcd(int n, int b){
    if(n%b == 0) return b;
    else return gcd(b,n%b);
}

int* rotate(int arr[], int n, int d){
    int i;
    int var = gcd(n,d);
    for(i=0; i<var;i++){
        int temp = arr[i];
        int j = i;
        while(j+var < n){
            arr[j] = arr[j+var];
            j+=var;
        }
        arr[(n-var)+i] = temp;
    }
    return arr;
}

int main()
{
    int i,d,t,n,j;
    int* ans;
    scanf("%d",&t);
    for(j=0; j<t; j++){
        scanf("%d",&n);
    //printf("%d",gcd(12,3));
    int arr[n];
    for(i=0; i<n; i++){
        scanf("%d",&arr[i]);
    }
    scanf("%d",&d);
    ans = rotate(arr,n,d);
    for(i=0; i<n; i++){
        printf("%d\t",*(ans+i));
    }
    }
    return 0;
}
