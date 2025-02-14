import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tyler Hinkie
 */

public class MakingChange {

    private static int[] possibleCoins;
    private static long[][] memoization;

    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);

        int length = coins.length;

        possibleCoins = new int[length];

        for (int i = 0; i < length; i++) {
            possibleCoins[i] = coins[length - i - 1];
        }

        return findWayTabulation(0, target);

//        memoization = new long[length][target + 1];
//        return findWayMemoization(0, target);
    }

//    private static long findWayMemoization(int index, int remaining) {
//        if (remaining == 0) return 1;
//        if (remaining < 0 || index == memoization.length) return 0;
//
//        if (memoization[index][remaining] != 0) return memoization[index][remaining];
//
//        long include = findWayMemoization(index, remaining - possibleCoins[index]);
//        long exclude = findWayMemoization(index + 1, remaining);
//
//        memoization[index][remaining] = include + exclude;
//
//        return memoization[index][remaining];
//    }

    private static long findWayTabulation(int index, int target) {
        long[][] tabulation = new long[possibleCoins.length][target + 1];

        for (int i = 0; i < tabulation.length; i++) {
            tabulation[i][0] = 1;
        }

        int include;
        int exclude;

        for (int i = 0; i < tabulation.length; i++) {
            for (int j = 1; j < tabulation[0].length; j++) {
                include = i - 1;
                exclude = j - possibleCoins[i];
                if (include >= 0) {
                    tabulation[i][j] += tabulation[include][j];
                }

                if (exclude >= 0) {
                    tabulation[i][j] += tabulation[i][exclude];
                }
            }
        }

        return tabulation[tabulation.length - 1][tabulation[0].length - 1];
    }
}
