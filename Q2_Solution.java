/*
    Q2. Given two sorted arrays nums1 and nums2,
        return a single sorted array.

        Constraints

        Arrays may be empty

        Negative numbers allowed

        Example: 

        nums1 = [1,3,5]
        nums2 = [2,4,6]
        Output = [1,2,3,4,5,6]


        Time complexity?

        Can you do it without extra space? 

        Where is this used in real systems?
*/

import java.util.*;

public class Q2_Solution {
    /*
        Time Complexity: O(m+n)
            m: length of arr1
            n: length of arr2

        Space Complexity: O(1)
            Explanation:
                We are not using any extra space.
                We are using the output array to store the result, which is not extra space.

        Where is this used in real systems?
            merging user uploaded files from multiple sources sorted by date, size or other criteria.

    */
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0){
            return arr2;
        }

        if(arr2 == null || arr2.length == 0){
            return arr1;
        }

        int index1 = 0;

        int index2 = 0;

        int m = arr1.length;

        int n = arr2.length;

        int[] result =  new int[m+n];

        int index = 0;

        while(index1 < m && index2 < n){
            if(arr1[index1] <= arr2[index2]){
                result[index++] = arr1[index1];

                index1++;
            } else {
                result[index++] = arr2[index2];

                index2++;
            }
        }

        if(index1 == m){
            while(index2 < n){
                result[index++] = arr2[index2++];
            }
        }

        if(index2 == n){
            while(index1 < m){
                result[index++] = arr1[index1++];
            } 
        }

        return result;
    }

    private static void assertEquals(int[] actual, int[] expected) {
        if (!Arrays.equals(actual, expected)) {
            throw new AssertionError("Expected " + 
                Arrays.toString(expected) + " but got " + 
                Arrays.toString(actual));
        }
    }

    public static void testMergeSortedArrays() {
        Q2_Solution solution = new Q2_Solution();

        assertEquals(solution.mergeSortedArrays(new int[] {1,3,5}, new int[] {2,4,6}), 
                new int[] {1,2,3,4,5,6});
        
        assertEquals(solution.mergeSortedArrays(new int[] {}, new int[] {2,4,6}), 
                new int[] {2,4,6});

        assertEquals(solution.mergeSortedArrays(new int[] {1,3,5}, new int[] {}), 
                new int[] {1,3,5});

        assertEquals(solution.mergeSortedArrays(new int[] {}, new int[] {}), 
                new int[] {});

        assertEquals(solution.mergeSortedArrays(new int[] {-1,0,3}, new int[] {-2,5,6}), 
                new int[] {-2,-1,0,3,5,6});
    }

    public static void main(String[] args){
        try {
            testMergeSortedArrays();

            System.out.println("testMergeSortedArrays passed");
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
            System.exit(1);
        }
    }
}
