import java.util.*;

import static java.lang.Math.max;

class Ninja {
    static Set<Integer> ans = new HashSet<>();
    static int max = 0;

    public static void main(String[] args) {
        int[][] points = {{10, 50, 1}, {5, 100, 11}};

        System.out.println(ninjaTraining(points.length, points));
    }

    public static int ninjaTraining(int n, int points[][]) {
        //Dynamic Programming
        int[][] dp = new int[points.length][points[0].length];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(ninjaTrainingDP(n - 1, points, dp));
        System.out.println(ninjaTrainingTabulation(2,points));
        //Recursion
        return ninjaTraining(n, 0, points, 0);
    }

    /**
     * Point Array
     * 10 40 70
     * 20 50 80
     * 30 60 90
     * Dynamic Programming - memoization
     */
    public static int ninjaTrainingDP(int row, int points[][], int[][] dp) {
        if (row < 0) {
            return 0;
        }
        int temp = 0, max = 0;
        for (int i = 0; i < 3; i++) {// traverse the entire row
            if (points[row][i] != -1) { // Non blocking cell
                if (dp[row][i] == -1) {
                    if ((row - 1) >= (0)) {
                        temp = points[row - 1][i];
                        points[row - 1][i] = -1;
                    }
                    dp[row][i] = max(dp[row][i], points[row][i] + ninjaTrainingDP(row - 1, points, dp));
                    if ((row - 1) >= (0)) {
                        points[row - 1][i] = temp;
                    }
                }
                max = Math.max(max, dp[row][i]);
            }
        }
        return max;
    }

    /**
     * Point Array
     * 10 40 70
     * 20 50 80
     * 30 60 90
     */
    public static int ninjaTraining(int n, int row, int points[][], int sum) {
        if (row > (n - 1)) {
            if (max < sum) {
                max = sum;
            }
            return max;
        }
        int temp = 0;
        for (int i = 0; i < 3; i++) { // traverse the entire row
            if (points[row][i] != -1) { // Non blocking cell
                if ((row + 1) < (n)) {
                    temp = points[row + 1][i];
                    points[row + 1][i] = -1;
                }
                ninjaTraining(n, row + 1, points, points[row][i] + sum);
                if ((row + 1) < (n)) {
                    points[row + 1][i] = temp;
                }
            }
        }
        return max;
    }

    /**Tabulation - Bottom Up*/
    public static int ninjaTrainingTabulation(int n, int points[][]) {
        int[][] dp = new int[points.length][points[0].length];
        dp[0][0]=points[0][0];
        dp[0][1]=points[0][1];
        dp[0][2]=points[0][2];
        int row=1;
        while(row < n){
            for(int col=0;col<3;col++){
                int max=0;
                for(int j=0;j<3;j++){
                    if(j!=col){
                        max= Math.max(max,dp[row-1][j]);
                    }
                }
                dp[row][col]=points[row][col]+max;
            }
            row++;
        }
        return dp[n-1][2];
    }
}