import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class CountNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, count = 0, totalCount = 0;

        while (left <= right) {
            //Till reaches the count == k,move the right pointer.
            while (right < nums.length && count <= k) {
                if (nums[right] % 2 == 1) {
                    if (count < k) {
                        count++;
                    } else {
                        break;
                    }
                }
                right++;
                if (count == k) {
                    totalCount++;
                }
            }
            // Right reaches the max ,but still no k count means - no k odd numbers.Return 0;
            if (right == nums.length && totalCount == 0) {
                break;
            } else {
                while(left <nums.length && nums[left]%2==1) { // till left odd number ,increase the total count;
                    totalCount++;
                    left++;
                }
//                if (left < nums.length && nums[left] % 2 == 1) { // if left is odd number
//                    count--;
//                } else if (count == k) { // even number
//                    totalCount++;
//                }

            }
        }
        return totalCount;
    }
}