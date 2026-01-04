/*For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"

Output: "ABC"

Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"

Output: "AB"

Example 3:

Input: str1 = "LEET", str2 = "CODE"

Output: ""

Example 4:

Input: str1 = "AAAAAB", str2 = "AAA"

Output: ""



Constraints:

        1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.*/
public class GcdOfStrings {
    public String gcdOfStrings1(String str1, String str2) {
        String out = "";
        //Step 1: Find the minimum length String
        String minStr = str1;
        String maxStr = str2;
        int minLen = minStr.length();
        int maxLen = maxStr.length();
        if (str2.length() < str1.length()) {
            minStr = str2;
            maxStr = str1;
            minLen = minStr.length();
            maxLen = maxStr.length();
        }
        //Use Case 1: If bigger string is starting with smaller string
        //using regionMatches to avoid creating new substring in startsWith
        if (maxStr.regionMatches(0, minStr, 0, minLen)) {
            out = minStr;//base case
            if (minLen != maxLen) {
                String remStr = maxStr.substring(minStr.length());
                //Recursive call
                out = gcdOfStrings(minStr, remStr);
            }
        }
        return out;
    }

    public String gcdOfStrings(String str1, String str2) {
        String out = "";
        //Step 1: Find the minimum length String
        String minStr = str1;
        String maxStr = str2;
        int minLen = minStr.length();
        int maxLen = maxStr.length();
        if (str2.length() < str1.length()) {
            minStr = str2;
            maxStr = str1;
            minLen = minStr.length();
            maxLen = maxStr.length();
        }
        //Use Case 1: If bigger string is starting with smaller string
        if (maxStr.startsWith(minStr)) {
            out = minStr;
            //Logic to be added
            if (minLen != maxLen) {
                String remStr = maxStr.substring(minStr.length());
                int remLen = remStr.length();
                if (remLen <= minStr.length()) {
                    if (minStr.startsWith(remStr)) {
                        //Recursion
                        out = gcdOfStrings(minStr, remStr);
                    } else {
                        out = "";
                    }
                } else {
                    //Recursion
                    out = gcdOfStrings(minStr, remStr);
                }
            }
        }
        return out;

    }
}


