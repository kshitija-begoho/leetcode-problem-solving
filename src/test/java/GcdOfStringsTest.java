import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GcdOfStringsTest {

    @Test
    void example1() {
        assertEquals("ABC", new GcdOfStrings().gcdOfStrings("ABCABC", "ABC"));
    }

    @Test
    void example2() {
        assertEquals("AB", new GcdOfStrings().gcdOfStrings("ABABAB", "ABAB"));
    }

    @Test
    void example3() {
        assertEquals("", new GcdOfStrings().gcdOfStrings("LEET", "CODE"));
    }

    @Test
    void example4() {
        assertEquals("", new GcdOfStrings().gcdOfStrings("AAAAAB", "AAA"));
    }

    @Test
    void bothEqual() {
        assertEquals("XYZ", new GcdOfStrings().gcdOfStrings("XYZ", "XYZ"));
    }

    @Test
    void oneIsPrefixButNotDivisor() {
        assertEquals("", new GcdOfStrings().gcdOfStrings("ABABABX", "AB"));
    }

    @Test
    void aaAndAaaaaReturnA() {
        assertEquals("A", new GcdOfStrings().gcdOfStrings("AA", "AAAAA"));
    }

    // Additional edge cases
    @Test
    void aAndAaaaaReturnA() {
        assertEquals("A", new GcdOfStrings().gcdOfStrings("A", "AAAAA"));
    }

    @Test
    void aaAndaaaaReturnAA() {
        assertEquals("AA", new GcdOfStrings().gcdOfStrings("AA", "AAAA"));
    }

    @Test
    void abcAndAbcabReturnEmpty() {
        assertEquals("", new GcdOfStrings().gcdOfStrings("ABCABC", "ABCAB"));
    }

    @Test
    void singleCharBothReturnChar() {
        assertEquals("B", new GcdOfStrings().gcdOfStrings("B", "BBBB"));
    }

    @Test
    void aaaAndaaReturnA() {
        assertEquals("A", new GcdOfStrings().gcdOfStrings("AAA", "AA"));
    }

    @Test
    void abAndbaReturnEmpty() {
        assertEquals("", new GcdOfStrings().gcdOfStrings("AB", "BA"));
    }

    @Test
    void tauxxCaseReturnsTAUXX() {
        String s1 = "TAUXXTAUXXTAUXXTAUXXTAUXX"; // 5 repeats
        String s2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"; // 9 repeats
        assertEquals("TAUXX", new GcdOfStrings().gcdOfStrings(s1, s2));
    }

}
