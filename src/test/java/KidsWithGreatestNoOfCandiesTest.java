import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNoOfCandiesTest {

    @Test
    void example1() {
        int[] candies = {2,3,5,1,3};
        List<Boolean> expected = Arrays.asList(true, true, true, false, true);
        List<Boolean> actual = new KidsWithGreatestNoOfCandies().kidsWithCandies(candies, 3);
        assertIterableEquals(expected, actual);
    }

    @Test
    void example2() {
        int[] candies = {4,2,1,1,2};
        List<Boolean> expected = Arrays.asList(true, false, false, false, false);
        List<Boolean> actual = new KidsWithGreatestNoOfCandies().kidsWithCandies(candies, 1);
        assertIterableEquals(expected, actual);
    }

    @Test
    void example3() {
        int[] candies = {12,1,12};
        List<Boolean> expected = Arrays.asList(true, false, true);
        List<Boolean> actual = new KidsWithGreatestNoOfCandies().kidsWithCandies(candies, 10);
        assertIterableEquals(expected, actual);
    }

    @Test
    void allSame() {
        int[] candies = {5,5,5};
        List<Boolean> expected = Arrays.asList(true, true, true);
        List<Boolean> actual = new KidsWithGreatestNoOfCandies().kidsWithCandies(candies, 0);
        assertIterableEquals(expected, actual);
    }

    @Test
    void singleLargeExtra() {
        int[] candies = {1,2,3};
        List<Boolean> expected = Arrays.asList(true, true, true);
        List<Boolean> actual = new KidsWithGreatestNoOfCandies().kidsWithCandies(candies, 100);
        assertIterableEquals(expected, actual);
    }

}
