import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Tyler Hinkie
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */

    private static int[] possibleCoins;
    private static int[][] memoization;

    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);

        int length = coins.length;

        possibleCoins = new int[length];

        for (int i = 0; i < length; i++) {
            possibleCoins[i] = coins[length - i - 1];
        }

        memoization = new int[length][target + 1];
        return 0;
    }

    private static long wayPath(int index, int remaining) {

    }
}
