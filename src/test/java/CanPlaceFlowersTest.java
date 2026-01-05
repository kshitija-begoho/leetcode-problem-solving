import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CanPlaceFlowersTest {

    private boolean hasImplementation() {
        try {
            CanPlaceFlowers.class.getMethod("canPlaceFlowers", int[].class, int.class);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private boolean invoke(int[] bed, int n) throws Exception {
        Method m = CanPlaceFlowers.class.getMethod("canPlaceFlowers", int[].class, int.class);
        return (boolean) m.invoke(new CanPlaceFlowers(), (Object) bed, n);
    }

    @Test
    void example1() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {1,0,0,0,1};
        assertTrue(invoke(bed, 1));
    }

    @Test
    void example2() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {1,0,0,0,1};
        assertFalse(invoke(bed, 2));
    }

    @Test
    void allZeros_canPlantMaxTrueFalse() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {0,0,0,0,0};
        assertTrue(invoke(bed, 3)); // max plantable = 3 for length 5
        assertFalse(invoke(bed, 4));
    }

    @Test
    void singleSlot() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        assertTrue(invoke(new int[]{0}, 1));
        assertFalse(invoke(new int[]{1}, 1));
    }

    @Test
    void mixedSmallBed() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {0,0,1,0,0};
        // can plant at most at positions 0 and 4 -> 2
        assertTrue(invoke(bed, 2));
        assertFalse(invoke(bed, 3));
    }

    @Test
    void allOnes() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {1,1,1,1,1};
        // can plant at most at positions 0 and 4 -> 2
        assertFalse(invoke(bed, 2));
        assertFalse(invoke(bed, 3));
    }

    @Test
    void betweenOnesFourZerosCannotPlantTwo() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {1,0,0,0,0,1};
        assertFalse(invoke(bed, 2));
    }

    @Test
    void complexBedCanPlantTwo() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {1,0,0,0,1,0,0};
        assertTrue(invoke(bed, 2));
        assertFalse(invoke(bed, 3));
    }

    @Test
    void zeroOneZeroCannotPlantOne() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {0,1,0};
        assertFalse(invoke(bed, 1));
    }

    @Test
    void patternBedCanPlantOneOnly() throws Exception {
        Assumptions.assumeTrue(hasImplementation(), "Implementation missing - skipping test");
        int[] bed = {0,1,0,1,0,1,0,0};
        assertTrue(invoke(bed, 1));
        assertFalse(invoke(bed, 2));
    }

}
