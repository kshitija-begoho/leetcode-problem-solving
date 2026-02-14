/*Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

        Note: The characters in the array beyond the returned length do not matter and should be ignored.



Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".


Constraints:

        1 <= chars.length <= 2000
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.*/
public class StringCompression {

    // Method signature expected by tests. Intentionally not implemented here per user's request.
    public int compress(char[] chars) {

        if(chars.length == 1)
        {
            return 1;
        }
        int arrayCount = 1;
        //Algorithm
        //Step 1: start 2 consecutive patterns
        int start = 0;
        int consc = 1;
        int writePointer = 1;
        int conscCount = 1;
        while(start < chars.length && consc < chars.length)
        {
           if(chars[start] == chars[consc])
           {
               conscCount++;
               start++;
           }
           else if (consc == chars.length-1)
           {
               conscCount = 1;
               arrayCount++;
           }
           else if(chars[start] != chars[consc]){
if(conscCount > 1) {
    arrayCount += findConsCountLength(conscCount);
}
               conscCount = 1;
               arrayCount++;
           }
           start++;
           consc++;
        }
        if(conscCount > 1) {
            arrayCount += findConsCountLength(conscCount);
        }
        return arrayCount;
    }

    private int findConsCountLength(int conscCount) {
        //find no of digits
        return Integer.toString(conscCount).length();
    }

}
