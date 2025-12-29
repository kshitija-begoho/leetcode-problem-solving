import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeStringsAltTest {

    @Test
    void mergesEqualLengthStrings() {
        assertEquals("axbycz", MergeStringsAlt.mergeAlternately("abc", "xyz"));
    }

    @Test
    void mergesWhenFirstLonger() {
        assertEquals("axbyczd", MergeStringsAlt.mergeAlternately("abcd", "xyz"));
    }

    @Test
    void mergesWhenSecondLonger() {
        assertEquals("axbyczw", MergeStringsAlt.mergeAlternately("abc", "xyzw"));
    }

}
