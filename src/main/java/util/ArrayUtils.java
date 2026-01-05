package util;

public class ArrayUtils {

    //Finding Max does not need sorting of array.
    //It just needs linear scan of array to find the max value.
    // Second greatest also could be found in single pass.
    //Time Complexity : O(n)
    //Space Complexity : O(1)
    public static int findMax(int[] candies) {
        int max = candies[0];
        for (int i = 1;i < candies.length;i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        //Streams API way take more time due to overhead of creating stream
        //  int max = Arrays.stream(candies).max().getAsInt();
        return max;
    }
}
