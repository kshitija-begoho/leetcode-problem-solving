import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdOfArrExSelfTest {

    @Test
    void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        //print expected array
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    @Test
    void example2_containsZero() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    //create one more test with 5 elements excluding zero
    @Test
    void fiveElementsNoZero() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {120, 60, 40, 30, 24};
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    //Add 7 elements test


    @Test
    void twoElements() {
        int[] nums = {2, 3};
        int[] expected = {3, 2};
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    @Test
    void multipleZeros() {
        int[] nums = {0, 0, 2};
        int[] expected = {0, 0, 0};
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    @Test
    void negativesAndOnes() {
        int[] nums = {1, -1, 1, -1};
        int[] expected = {1, -1, 1, -1};
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    @Test
    void largerExample() {
        int[] nums = {5, 6, 2, 4};
        // total product = 240 -> except: [48,40,120,60]
        int[] expected = {48, 40, 120, 60};
        System.out.println("Expected array:");
        for(int e:expected)
        {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    //Add 7 elements test and 8 elements test
    @Test
    void sevenElements() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5040, 2520, 1680, 1260, 1008, 840, 720};
        System.out.println("Expected array:");
        for(int e: expected) {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    //add 8 elements test
    @Test
    void eightElements() {
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {181440, 120960, 90720, 72576, 60480, 51840, 45360, 40320};
        System.out.println("Expected array:");
        for(int e: expected) {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }

    //add 3 element non zero test
    @Test
    void threeElementsNoZero() {
        int[] nums = {3, 4, 5};
        int[] expected = {20, 15, 12};
        System.out.println("Expected array:");
        for (int e : expected) {
            System.out.println(e);
        }
        assertArrayEquals(expected, new ProdOfArrExSelf().productExceptSelf(nums));
    }



}

