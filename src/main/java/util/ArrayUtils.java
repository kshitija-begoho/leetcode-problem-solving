package util;

public class ArrayUtils {

    //Finding Max does not need sorting of array.
    //It just needs linear scan of array to find the max value.
    // Second greatest also could be found in single pass.
    //Time Complexity : O(n)
    //Space Complexity : O(1)
    public static int findMax(int[] candies) {
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        //  int max = Arrays.stream(candies).max().getAsInt();
        return max;
    }
}
