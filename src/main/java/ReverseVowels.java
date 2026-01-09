import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"



Constraints:

        1 <= s.length <= 3 * 105
s consist of printable ASCII characters.*/
public class ReverseVowels {
    public String reverseVowels2(String s) {
        //Step 1: Convert string to char array
        char[] charArray = s.toCharArray();
        List<Character> vowelList = new ArrayList<>();
        //Step 2: Start iterating String from End
        for (int i = charArray.length - 1; i >= 0; i--) {
            //Step 3: Check if char is a vowel
            if (isVowel(charArray[i])) {
                //Step 4: If Vowel, add to the list in Reverse order
                vowelList.add(charArray[i]);
            }
        }
        //convert vowelList to array for easy access
        Character[] reversedVowels = new Character[vowelList.size()];
        //add elements from list to array
        vowelList.toArray(reversedVowels);
        int j = 0;
        //Step 5: Iterate again from start and replace vowels from the list
        for (int i = 0; i < charArray.length; i++) {
            if (isVowel(charArray[i])) {
                //Step 6: Replace vowel with the reversed vowel from the list
                charArray[i] = reversedVowels[j++];
            }
        }
        return new String(charArray);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

    //version 2 using two pointers
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        for(int start = 0, end = charArray.length -1; start < end;)
        {
            if(!isVowel(charArray[start]))
            {
                start++;
            }
            if(!isVowel(charArray[end]))
            {
                end--;
            }
            if(start < end && isVowel(charArray[start]) && isVowel(charArray[end]))
            {
                //both are vowels, swap
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;end--;
            }
        }
        return new String(charArray);
    }

}
