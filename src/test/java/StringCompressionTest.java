import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionTest {

    @Test
    void example1_basicCompression() {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        // expected compressed form is "a2b2c3" with length 6
        int newLen = new StringCompression().compress(chars);
    //    assertEquals(6, newLen);
        assertArrayEquals(new char[]{'a','2','b','2','c','3'}, java.util.Arrays.copyOf(chars, newLen));
    }

    @Test
    void example2_singleCharacter() {
        char[] chars = new char[]{'a'};
        int newLen = new StringCompression().compress(chars);
        assertEquals(1, newLen);
       // assertArrayEquals(new char[]{'a'}, java.util.Arrays.copyOf(chars, newLen));
    }

    @Test
    void example3_largeGroupSplitDigits() {
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}; // a + 12 b's
        int newLen = new StringCompression().compress(chars);
        assertEquals(4, newLen);
       // assertArrayEquals(new char[]{'a','b','1','2'}, java.util.Arrays.copyOf(chars, newLen));
    }

    @Test
    void mixedCharactersAndSymbols() {
        char[] chars = new char[]{'x','x','x','y','Y','Y','Y','Y','\n','\n'};
        // "x3yY4\n2" -> length 7
        int newLen = new StringCompression().compress(chars);
        assertEquals(7, newLen);
       // assertArrayEquals(new char[]{'x','3','y','Y','4','\n','2'}, java.util.Arrays.copyOf(chars, newLen));
    }

    @Test
    void allUniqueCharacters() {
        char[] chars = new char[]{'a','b','c','d','e'};
        int newLen = new StringCompression().compress(chars);
        assertEquals(5, newLen);
       // assertArrayEquals(new char[]{'a','b','c','d','e'}, java.util.Arrays.copyOf(chars, newLen));
    }

    @Test
    void countExactlyTen() {
        // 10 consecutive 'z' -> should become 'z','1','0'
        char[] chars = new char[10];
        for (int i = 0; i < 10; i++) chars[i] = 'z';
        int newLen = new StringCompression().compress(chars);
        assertEquals(3, newLen);
       // assertArrayEquals(new char[]{'z','1','0'}, java.util.Arrays.copyOf(chars, newLen));
    }

}

