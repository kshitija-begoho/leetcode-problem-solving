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
public class CanPlaceFlowers {
    //version 2
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean canPlace = false;
        int length = flowerbed.length;
        if (length == 1) {
            if (flowerbed[0] == 0) {
                n = 0;
            }
        }
        else if(length > 1)
        {
            for (int i = 0; i < length; i++) {
                    //checking there are no adjacent flowers planted
                    if (flowerbed[i] == 0 && (i== length-1 || flowerbed[i + 1] == 0) && (i == 0 || flowerbed[i - 1] == 0)) {
                        n--;
                        i++;//skip next position as we have planted flower here
                        if (n == 0) {
                            break;
                        }
                    }
            }
        }
        if(n <= 0)
        {
            canPlace = true;
        }
        return canPlace;
    }

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
