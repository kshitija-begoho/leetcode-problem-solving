import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseWordsTest {

    @Test
    void example1_theSkyIsBlue() {
        String input = "the sky is blue";
        String expected = "blue is sky the";
        assertEquals(expected, new ReverseWords().reverseWords(input));
    }

    @Test
    void example2_leadingTrailingSpaces() {
        String input = "  hello world  ";
        String expected = "world hello";
        assertEquals(expected, new ReverseWords().reverseWords(input));
    }

    @Test
    void example3_reduceMultipleSpaces() {
        String input = "a good   example";
        String expected = "example good a";
        assertEquals(expected, new ReverseWords().reverseWords(input));
    }

    @Test
    void singleWord_returnsSame() {
        String input = "word";
        String expected = "word";
        assertEquals(expected, new ReverseWords().reverseWords(input));
    }

    @Test
    void multipleSpacesOnlyBetweenWords() {
        String input = "  Bob    Loves  Alice  ";
        String expected = "Alice Loves Bob";
        assertEquals(expected, new ReverseWords().reverseWords(input));
    }

    @Test
    void userProvided_asdasd_df_f() {
        String input = " asdasd df f";
        String expected = "f df asdasd";
        assertEquals(expected, new ReverseWords().reverseWords(input));
    }

}
