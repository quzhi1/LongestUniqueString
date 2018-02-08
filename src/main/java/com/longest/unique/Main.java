package com.longest.unique;

import java.util.HashMap;

/*
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

// The following code is initially written by Srikanth Munjuluri during a phone interview.
// I haven't seen such an implementation before. So I want to test it out locally.

//brute approach - create all the substrings--dicard which have duplicate/repeat character - out of remaining, choose the one with the max length
// abcab - 5 letters
// iterate char by char..keep replacing the max_length when the urr value is great
// if i see the repeated char, shsift t he cur_start by 1
// map-(char,position) HashMap<Character, Integer>
//

class Main {

    public static void main(String[] args) {
        System.out.println(subUnique(""));
        System.out.println(subUnique("abacbcaaxzvc"));
        System.out.println(subUnique("abcdabcabdd"));
        System.out.println(subUnique("abcddbca"));
        System.out.println(subUnique("xxxababcdeabcxyzrstvuc"));
    }

    private static int subUnique(String given) {
        if (given == null) {
            return 0;
        }
        if (given.length() == 0) {
            return 0;
        }
        if (given.length() == 1) {
            return 1;
        }
        int max_length = 1;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put(given.charAt(0), 0);
        int start = 0;
        for (int i = 1; i < given.length(); i++) {
            if (hm.containsKey(given.charAt(i))) {
                if (start < hm.get(given.charAt(i)) + 1) {
                    start = hm.get(given.charAt(i)) + 1;
                }
                hm.put(given.charAt(i), i);
            } else {
                hm.put(given.charAt(i), i);
            }
            if (max_length < (i - start + 1)) {
                max_length = i - start + 1;
            }
        }

        return max_length;
    }
}
