/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.


        Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false


Constraints:

        1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
        0 <= n <= flowerbed.length*/
/**
 * Utility methods related to the "Can Place Flowers" problem.
 *
 * <p>The class provides two implementations that decide whether {@code n} new flowers
 * can be planted in a given {@code flowerbed} (an array of 0/1) without planting
 * flowers in adjacent plots. The typical greedy approach is to scan the array once
 * and plant whenever a plot and its neighbors (if any) are empty.</p>
 *
 * <p>Examples:
 * <pre>
 *   flowerbed = [1,0,0,0,1], n = 1 -> true
 *   flowerbed = [1,0,0,0,1], n = 2 -> false
 * </pre>
 *
 * Complexity: the typical implementations run in O(L) time and O(1) extra space,
 * where L = flowerbed.length.</p>
 */
public class CanPlaceFlowers {
    //version 2

    /**
     * Determine whether {@code n} new flowers can be planted in {@code flowerbed}
     * without violating the no-adjacent-flowers rule.
     *
     * <p>Algorithm (greedy single-pass): iterate the array and whenever we find a
     * position {@code i} with value 0 such that the left neighbor (if any) and the
     * right neighbor (if any) are also 0, we "plant" a flower there (logically),
     * decrement {@code n} and skip the next position because we cannot plant adjacent
     * to the newly planted flower. If {@code n} reaches 0 we return {@code true}.
     * Otherwise we return {@code false} after completing the scan.</p>
     *
     * @param flowerbed an array of 0/1 where 0 indicates an empty plot and 1 indicates
     *                  an occupied plot. Assumed to contain no adjacent 1s initially.
     * @param n         the number of new flowers to plant (0 <= n <= flowerbed.length)
     * @return {@code true} if it is possible to plant {@code n} new flowers without
     *         creating adjacent planted plots; {@code false} otherwise
     *
     * @implSpec This implementation handles the length==1 case explicitly. It uses
     *           a greedy O(L) scan and O(1) extra space.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean canPlace = false;
        int length = flowerbed.length;
        if (length == 1) {
            if (flowerbed[0] == 0) {
                n = 0;
            }
        } else if (length > 1) {
            for (int i = 0; i < length; i++) {
                //checking there are no adjacent flowers planted
                if (flowerbed[i] == 0 && (i == length - 1 || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {
                    n--;
                    i++;//skip next position as we have planted flower here
                    if (n == 0) {
                        break;
                    }
                }
            }
        }
        if (n <= 0) {
            canPlace = true;
        }
        return canPlace;
    }

    /**
     * Alternate (more branchy) implementation that computes the number of eligible
     * planting positions and compares it to {@code n}.
     *
     * <p>This method contains a few case splits (all-zero optimization, first-slot
     * checks, separate handling for last position) and returns {@code true} if the
     * computed number of eligible positions is at least {@code n}.</p>
     *
     * @param flowerbed the flowerbed array (0/1)
     * @param n         the required number of new flowers to plant
     * @return {@code true} if {@code n} flowers can be planted, otherwise {@code false}
     *
     * @implNote This variant is more verbose and contains optimizations for special
     *           cases; prefer the simpler {@link #canPlaceFlowers(int[], int)} for
     *           clarity unless micro-optimizations are required and proven necessary.
     */
    public boolean canPlaceFlowers_v2(int[] flowerbed, int n) {

        boolean canPlace = false;
        int eligibleCount = 0;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                eligibleCount = 1;
            }
        }
        else if(flowerbed.length > 1){
            //Use Case 1: Depending on n just iterate n times and check if eligible count equals n then return true
            // iterate n times
            //Case 1: First position is 1
            if (flowerbed[0] == 1) {
                //Iterate on even positions
                for (int i = 0; i < flowerbed.length; i++) {
                    //checking there are no adjacent flowers planted//0,2,4,6
                    if (i + 1 < flowerbed.length) {
                        if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                            eligibleCount = eligibleCount + 1;
                            i++;//skip next position as we have planted flower here
                            if (eligibleCount == n) {
                                break;
                            }
                        }
                    } else if (i + 1 >= flowerbed.length) //last position
                    {
                        if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                            eligibleCount = eligibleCount + 1;
                        }
                    }

                }
            } else if (flowerbed[0] == 0) {
                //check if all are zeros
                boolean allZeros = true;
                for (int i = 0; i < flowerbed.length; i++) {
                    if (flowerbed[i] == 1) {
                        allZeros = false;
                        break;
                    }
                }
                if (allZeros
                ) {
                    eligibleCount = flowerbed.length / 2 + flowerbed.length % 2;
                } else {
                    //iterate on odd positions
                    if (flowerbed[1] != 1) {
                        eligibleCount = 1;//first position is eligible
                    }
                    for (int i = 2; i < flowerbed.length; i++) {

                        if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                            if (i + 1 < flowerbed.length) {
                                if (flowerbed[i + 1] == 0) {
                                    eligibleCount = eligibleCount + 1;
                                    i++;//skip next position as we have planted flower here

                                }
                            } else if (i + 1 >= flowerbed.length) {//last position
                                eligibleCount = eligibleCount + 1;
                            }
                            if (eligibleCount == n) {
                                break;
                            }
                        }

                    }

                }
            }
        }


        if(eligibleCount >= n){
            canPlace = true;
        }
        return canPlace;
    }

}
