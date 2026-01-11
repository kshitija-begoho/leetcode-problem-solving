class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //step 1: start iteration pointer 1 at the end of each array
        int pointer1 = m-1; //nums1
        int pointer2 = n-1; //nums2
        int write = nums1.length-1;
        //check if nums2 element is greater than num1
        while(write >= 0) {
            if (pointer1 >= 0 && pointer2 >= 0 && nums2[pointer2] >= nums1[pointer1]) {
                //in this case the fist number is greatest so send it towards end
                nums1[write] = nums2[pointer2];
                //now that element at pointer 2 is written we can decrement it
                pointer2--;
                //since write is also consumed
            }
            //similar approach for less or equal
            else if (pointer1 >= 0 && pointer2 >= 0 && nums1[pointer1] >= nums2[pointer2]) {
                nums1[write] = nums1[pointer1];
                pointer1 --;

            }
            else {
                if(pointer1 >= 0)
                {
                    nums1[write] = nums1[pointer1];
                    pointer1 --;
                }
                else if(pointer2 >= 0)
                {
                    nums1[write] = nums2[pointer2];
                    pointer2--;
                }
            }
            write--;
        }
    }
}