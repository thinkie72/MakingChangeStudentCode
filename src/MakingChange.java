import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tyler Hinkie
 */

public class MakingChange {

    // Allows us to see coins in both helper methods without parameterizing
    private static int[] possibleCoins;
    // Prevents us from passing in this array as a parameter for every recursive call for memoization
    private static long[][] memoization;

    // Starter method to count the number of ways to make a target number out of given coins using dynamic programming
    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);

        int length = coins.length;

        possibleCoins = new int[length];

        // Reverses the direction of the sorted coins, which I thought seemed faster
        for (int i = 0; i < length; i++) {
            possibleCoins[i] = coins[length - i - 1];
        }

        return findWayTabulation(target);

//        // Set up memoization array for separate recursive method
//        memoization = new long[length][target + 1];
//        return findWayMemoization(0, target);
    }

    // Calculates the number of ways to make the change using memoization
    private static long findWayMemoization(int index, int remaining) {
        if (remaining == 0) return 1;

        // Checks if we've gone over or index is out of bounds
        if (remaining < 0 || index == memoization.length) return 0;

        // Returns the value of the problem if we've solved it before
        if (memoization[index][remaining] != 0) return memoization[index][remaining];

        // All the possible ways including the coin
        long include = findWayMemoization(index, remaining - possibleCoins[index]);
        // All the possible ways excluding the coin
        long exclude = findWayMemoization(index + 1, remaining);

        // The number of ways must be the number of ways including
        // and excluding the first coin (and the others recursively)
        memoization[index][remaining] = include + exclude;

        return memoization[index][remaining];
    }

    // Calculates the number of ways to make the change using tabulation
    private static long findWayTabulation(int target) {
        // Sets up tabulation array
        long[][] tabulation = new long[possibleCoins.length][target + 1];

        // Sets first column all equal to 0
        for (int i = 0; i < tabulation.length; i++) {
            tabulation[i][0] = 1;
        }

        int include;
        int exclude;

        // Row-major traversal to calculate the ways
        for (int i = 0; i < tabulation.length; i++) {
            // Skips over first column since we've already initialized
            for (int j = 1; j < tabulation[0].length; j++) {
                // Looks one cell above
                include = i - 1;
                // Looks [the value of the coin] cells to the left
                exclude = j - possibleCoins[i];

                // Checks if new x is out of bounds
                if (include >= 0) {
                    tabulation[i][j] += tabulation[include][j];
                }

                // Checks if new y is out of bounds
                if (exclude >= 0) {
                    tabulation[i][j] += tabulation[i][exclude];
                }
            }
        }

        // Returns the cell in the bottom right corner of the array, which should be the summation of all the ways
        return tabulation[tabulation.length - 1][tabulation[0].length - 1];
    }
}
