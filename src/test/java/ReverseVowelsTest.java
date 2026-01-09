import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseVowelsTest {

    @Test
    void example1_IceCreAm() {
        String input = "IceCreAm";
        String expected = "AceCreIm";
        assertEquals(expected, new ReverseVowels().reverseVowels(input));
    }

    @Test
    void example2_leetcode() {
        String input = "leetcode";
        String expected = "leotcede";
        assertEquals(expected, new ReverseVowels().reverseVowels(input));
    }

    @Test
    void noVowels_returnsSame() {
        String input = "rhythm";
        String expected = "rhythm";
        assertEquals(expected, new ReverseVowels().reverseVowels(input));
    }

    @Test
    void allVowels_reversed() {
        String input = "aeiou";
        String expected = "uoiea";
        assertEquals(expected, new ReverseVowels().reverseVowels(input));
    }

    @Test
    void mixedCase_vowelsPreserveCasePositions() {
        String input = "AbEoU"; // vowels: A, E, o, U -> reversed: U, o, E, A
        String expected = "UboEA";
        assertEquals(expected, new ReverseVowels().reverseVowels(input));
    }

    @Test
    void singleChar_vowel() {
        assertEquals("a", new ReverseVowels().reverseVowels("a"));
    }

    @Test
    void singleChar_consonant() {
        assertEquals("b", new ReverseVowels().reverseVowels("b"));
    }

    @Test
    void palindromeVowels() {
        String input = "racecar"; // vowels: a,e,a -> reversed still a,e,a
        assertEquals("racecar", new ReverseVowels().reverseVowels(input));
    }

    @Test
    void longStringPerformanceLike() {
        StringBuilder sb = new StringBuilder();
        // build a long string with vowels sprinkled
        for (int i = 0; i < 1000; i++) {
            sb.append("bcd");
            sb.append((i % 2 == 0) ? 'a' : 'e');
        }
        String input = sb.toString();
        // reversing vowels twice should yield the original string
        ReverseVowels rv = new ReverseVowels();
        String once = rv.reverseVowels(input);
        String twice = rv.reverseVowels(once);
        assertEquals(input, twice);
    }

    @Test
    void example3_race_space_a_space_car() {
        String input = "race a car";
        String expected = "raca e car";
        assertEquals(expected, new ReverseVowels().reverseVowels(input));
    }
}
