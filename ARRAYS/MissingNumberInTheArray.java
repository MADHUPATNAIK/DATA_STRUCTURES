/*
Missing number in array

  Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.

Input:
  The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.

Output:
  Print the missing number in array.

Constraints:
  1 ≤ T ≤ 200
  1 ≤ N ≤ 107
  1 ≤ C[i] ≤ 107

Example:
Input:
  2
  5
  1 2 3 5
  10
  1 2 3 4 5 6 7 8 10

Output:
  4
  9
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class MissingNumberInTheArray {
    static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		int testCases = sc.nextInt();
		while(testCases-- > 0){
		    int sizeOfArray = sc.nextInt();
		    int[] array = new int[sizeOfArray+1];
		    for(int i=0; i<sizeOfArray-1; i++){
		        array[i] = sc.nextInt();
		    }
		    int[] arr = new int[sizeOfArray];
		    for(int i=0; i<sizeOfArray-1; i++){
		        arr[array[i]-1] = 1;
		    }
		    for(int i = 0; i< sizeOfArray; i++){
		        if(arr[i] == 0){
		            System.out.println(i+1);
		            break;
		        }
		    }
		}
	}
}
