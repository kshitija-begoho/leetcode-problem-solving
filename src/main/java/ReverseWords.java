/*Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


        Constraints:

        1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?*/
public class ReverseWords {
    public String reverseWords2(String s) {
        //Step 1: Trim the leading and trailing spaces
        s = s.trim();
        StringBuilder out = new StringBuilder();
        //Step 2: Split the string by spaces
        String[] words = s.split("\\s+");
        //step 3: Reverse the words array using 2 pointers
       for(int i = words.length-1; i >= 0; i--){
           out.append(words[i]).append(" ");
       }
return out.toString().trim();
    }
    //version 2
    // If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
    public String reverseWords(String s) {
        //Step 1: convert to char array
        char[] charArray = s.toCharArray();
        int write = 0;
        //2 pointer space trimming
        for(int i = 0; write < charArray.length; i++){
            if(i < charArray.length) {
                //trim the starting spaces
                if(i == 0 && charArray[i] == ' '){
                    continue;
                }
                //trim in between multiple spaces
               else if (i - 1 >= 0 && charArray[i] == ' ' && charArray[i - 1] == ' ') {
                    continue;
                //else copy char and shift write pointer
                } else {
                    charArray[write++] = charArray[i];
                }
            }
            else {
                charArray[write++] = ' ';
            }
        }
        // write--; // remove trailing space

        System.out.println("trimming spaces: "+new String(charArray));
        //step 2: Reverse the entire char array
        int start = 0;
        int end = write - 1;
            //skip extra spaces
            while(start < end)
            {
                //find extra spaces and skip
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        //System.out.println(new String(charArray));
        //Step 3: Reverse each word in the reversed char array
        int startWord = 0;
        int endWord = 0;
        for(int i=0; i< charArray.length; i++)
        {
           //find end of the word
            if(charArray[i] == ' ' || i == charArray.length -1)
            {
                endWord = i;
                //reverse the word from startWord to endWord-1
                while(startWord < endWord)
                {
                    char temp = charArray[startWord];
                    if(i == charArray.length -1)
                    {
                        charArray[startWord] = charArray[endWord];
                        charArray[endWord] = temp;
                    }
                    else {
                        charArray[startWord] = charArray[endWord - 1];
                        charArray[endWord - 1] = temp;
                    }

                    startWord++;
                    endWord--;
                }
                startWord = i + 1; //move to next word start


            }
        }
        return new String(charArray).trim();
    }

}
