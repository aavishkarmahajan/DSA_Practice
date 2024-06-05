/*
Problem Statement: 
Given a sorted array A containing N integers both positive and negative.
You need to create another array containing the squares of all the elements in A and return it in non-decreasing order.
Try to this in O(N) time.
*/

/*
Solution:
The array A is having negative elements also. After taking their squares they turn positive and disrupts the sorted array.
So what we do here is-
1. We create 2 seperate arrays out of the input array.One array will have positive elements and the other will have negative elements from the input array.
2. We take squares of the elements of these 2 new arrays(take squares while creating the array itself so that both step 1 and 2 happen at same time)
3. Now take 2 pointers. Pointer 1 will point to 1st element of positives array. Pointer 2 will point to last element of neagatives array(points to last since after having squares the negatives array becomes naturally sorted in DESC order)
4. Compare elements at both pointers. If element at Pointer 1 is less than element at Pointer 2, then add the element at Pointer 1 to results array. Increment Pointer 1.
    Else If element at Pointer 2 is less than element at Pointer 1, then add the element at Pointer 2 to results array. Increment Pointer 2.
5. Add remaining elements(if any) from positives/negatives array to results array.
6. return results array.
 
*/
public class Solution {
    public int[] solve(int[] A) {
        ArrayList<Integer> arrLNeg = new ArrayList<Integer>();
        ArrayList<Integer> arrLPos = new ArrayList<Integer>();
        int[] arrRes = new int[A.length];
        for(int i=0; i<A.length; i++){
            if(A[i]<0) arrLNeg.add(A[i]*A[i]);
            else arrLPos.add(A[i]*A[i]);
        }
        int i=0;
        int j=arrLNeg.size()-1;
        int k=0; 
        while(i<arrLPos.size() && j>=0){
            if(arrLPos.get(i)<arrLNeg.get(j)){
                arrRes[k]=arrLPos.get(i);
                i++;
            }
            else{
                arrRes[k]=arrLNeg.get(j);
                j--;
            }
            k++;
        }
        while(i<arrLPos.size()){
            arrRes[k]=arrLPos.get(i);
            i++;
            k++;
        }
        while(j>=0){
            arrRes[k]=arrLNeg.get(j);
            j--;
            k++;
        }
        return arrRes;
    }
}
