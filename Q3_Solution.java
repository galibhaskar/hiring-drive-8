/*
    Q3. What’s wrong with this code?

        public static int sum(int[] arr) {
            int total = 0;
            for (int i = 0; i <= arr.length; i++) {
                total += arr[i];
            }
            return total;
        }

        What is wrong?

        What happens at runtime?

        Fix the code.

*/

public class Q3_Solution {
    public static int sum(int[] arr) {
        int total = 0;

        /* 
            Issue is the with the index range,
                we are iterating till the size of arr (n),
                where indices are till n-1.@interface
            
            Fix:
                remove equality sign in the condition
                i.e., i < arr.length

                or you can do i <= arr.length-1
        

            What happens during runtime:
                ArrayIndexOutOfBoundsException will be thrown

                because we are trying to access arr[arr.length]

                which is out of bounds.
        */
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return total;
    }
}
