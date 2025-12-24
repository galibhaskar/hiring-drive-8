/*

Q1. Given a string s, return the index of the first non-repeating character.
If none exists, return -1.
Example: 
Input: "leetcode"
Output: 0

Input: "loveleetcode"
Output: 2

Input: "aabb"
Output: -1

Time and space complexity?

Can you do it in one pass?

What if the string is very large?

What if characters are Unicode?
*/

import java.util.*;

public class Q1_Solution {
    /* 
        Time Complexity: O(2n) ~ O(n)
            n:length of the string

            Explanation: 
                In the worst case - all repeating characters,
                    we iterate over all character in the string

        Space Complexity: O(n)
            n: length of the string
            
            Explanation:
                In the worst case - all repeating characters,
                    we end up storing all characters in the map

        Large String: Time and Space Complexity remains O(n)

        Unicode: If we have unicode characters, 
                    our HashMap will store them as Character objects.
            
            This will still be O(n) time complexity and O(n) space complexity.
    */
    public int firstNonRepeatingChar(String s) {
        Map<Character, Integer> seen = new HashMap<>();

        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
        }

        for(int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if(seen.containsKey(ch) && seen.get(ch) == 1){
                return index;
            }
        }

        return -1;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }

    public static void testFirstNonRepeatingChar() {
        Q1_Solution solution = new Q1_Solution();
        assertEquals(solution.firstNonRepeatingChar("leetcode"), 0);
        assertEquals(solution.firstNonRepeatingChar("loveleetcode"), 2);
        assertEquals(solution.firstNonRepeatingChar("aabb"), -1);
        assertEquals(solution.firstNonRepeatingChar(""), -1);
        assertEquals(solution.firstNonRepeatingChar("œ∫ßœ∫åß∂ƒ©˙∆˚¬…æ«`Ω≈ç√∫"), 5);
    }

    public static void main(String[] args){
        try {
            testFirstNonRepeatingChar();
            System.out.println("testFirstNonRepeatingChar passed");
            
            System.out.println("\nAll tests passed!");
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
            System.exit(1);
        }
    }
}