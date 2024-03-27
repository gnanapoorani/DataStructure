import static java.lang.Math.abs;
import static java.lang.Math.min;

class FrogJumpKdistance {
    public static void main(String[] args) {
        int[] energy = {40, 80, 50, 90, 100};
        int[] dp = {-1, -1, -1, -1, -1};
        System.out.println(findMinEnergy(energy, 4));
        System.out.println(findMinEnergyDP(energy, 4, dp));
        System.out.println(findMinEnergyKSteps(energy, 4, 4));
        System.out.println(findMinEnergyKStepsDP(energy, 4, 4,dp));
    }

    //Top-Down Approach- Recurrsion
    static int findMinEnergy(int[] energy, int n) {
        if (n < 1) {
            return 0;
        }
        int left = findMinEnergy(energy, n - 1) + abs(energy[n] - energy[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = findMinEnergy(energy, n - 2) + abs(energy[n] - energy[n - 2]);
        }
        return min(left, right);
    }

    //Dynamic Programming
    static int findMinEnergyDP(int[] energy, int n, int[] dp) {
        if (n < 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = findMinEnergy(energy, n - 1) + abs(energy[n] - energy[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = findMinEnergy(energy, n - 2) + abs(energy[n] - energy[n - 2]);
        }
        return dp[n] = min(left, right);
    }

    //Top-Down Approach- Recurrsion
    static int findMinEnergyKSteps(int[] energy, int n, int k) {
        if (n < 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                min = min(min, findMinEnergyKSteps(energy, n - i,4) + abs(energy[n] - energy[n - i]));
            } else {
                break;
            }
        }
        return min;
    }

    //Dynamic Programming
    static int findMinEnergyKStepsDP(int[] energy, int n, int k,int[] dp) {
        if (n < 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                min = min(min, findMinEnergyKSteps(energy, n - i,4) + abs(energy[n] - energy[n - i]));
            } else {
                break;
            }
        }
        return dp[n]=min;
    }
}