import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortedArrayTest {

    @Test
    void example1_mergeNormal() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }

    @Test
    void example2_singleElementNums1() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void example3_nums1Empty_mZero() {
        int[] nums1 = {0,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{0,1}, nums1);
    }

    @Test
    void bothEmpty_notAllowedByConstraints_butSafe() {
        int[] nums1 = { /* length 0 not allowed by constraints, use length 0 anyway */ };
        int m = 0;
        int[] nums2 = {};
        int n = 0;
        // If arrays of length 0 are used, nothing to do. We won't call merge because nums1 length must be m+n.
        assertEquals(0, m + n);
    }

    @Test
    void nums2AllSmaller() {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, nums1);
    }

    @Test
    void duplicatesAndNegatives() {
        int[] nums1 = {-1,0,0,0,0,0};
        int m = 1;
        int[] nums2 = {-1, -1, 2, 3, 3};
        int n = 5;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{-1,-1,-1,2,3,3}, nums1);
    }

}
