/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.*/

public class ProdOfArrExSelf {
    public int[] productExceptSelf2(int[] nums) {
        //output array will be same length as input array
        int[] out = new int[nums.length];
        //start 2 pointers one at start and one at end find their product
        int start = 0;
        int end = nums.length - 1;
        int endProd = 1;
        int midProd = 1;
        while(start <= end)
        {
            if(start == end)
            {
                out[start] = endProd;
                break;
            }
            for (int i = start+1; i < end; i++)
            {
                midProd = midProd * nums[i];
            }

            out[start] = endProd * midProd * nums[end];
            out[end] = endProd * midProd * nums[start];
            endProd = endProd * nums[start] * nums[end];
            midProd = 1;
            start++;
            end--;
        }
        return out;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];

        // First pass: out[i] = product of elements to the left of i
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            out[i] = prefix;
            prefix *= nums[i];
        }

        // Second pass: multiply by product of elements to the right of i
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            out[i] *= suffix;
            suffix *= nums[i];
        }

        return out;
    }
}
