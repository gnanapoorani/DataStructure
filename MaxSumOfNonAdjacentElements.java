import java.util.Arrays;

import static java.lang.Math.max;

class MaxSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        System.out.println(rob(nums));
        System.out.println(robCircularDP(nums,nums.length-1,false,dp));
        System.out.println(robIterative(nums));

    }
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robCircularDP(nums,nums.length-1,false,dp);
    }


    //Dynamic Programming
    public  static int rob1(int[] nums, int i,int[] dp) {
        int sum = 0;
        if (i < 0) {
            return sum;
        }
        if(dp[i]!=-1){
          return dp[i];
        }
        // pick the element and call the non adjacent index
//        // pick the element and call the non adjacent index
        return dp[i]= max(sum + nums[i] + rob1(nums, i - 2,dp), sum + rob1(nums, i - 1,dp));

    }

    //Top-Down Approach- Recurrsion
    public  static int robCircularDP(int[] nums, int i,int[] dp) {
        int sum = 0;
        if (i<0) {
            return sum;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        // pick the element and call the non adjacent index
//        // pick the element and call the non adjacent index

         return dp[i]=max(sum + nums[i] + robCircularDP(nums, i - 2,dp), sum + robCircularDP(nums, i - 1,dp));

    }

    public  static int robCircular(int[] nums, int i,boolean lastElementPick) {
        int sum = 0;
        if (i<0) {
            return sum;
        }
        if(i==0 & lastElementPick==true){
            return 0;
        }else if(i==0 & lastElementPick==false){
            return nums[0];
        }
        // pick the element and call the non adjacent index
//        // pick the element and call the non adjacent index
        return max(sum + nums[i] + robCircular(nums, i - 2,true), sum + robCircular(nums, i - 1,false));

    }

    //Iterative - Bottom Up + Memoization
    public  static int robIterative(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]= Math.max(dp[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

       return dp[nums.length-1];
    }

}