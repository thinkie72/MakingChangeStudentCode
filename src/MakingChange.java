import java.util.ArrayList;
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

        memoization = new long[length][target + 1];
        for (long[] row : memoization) Arrays.fill(row, -1);
        return findWay(0, target);
    }

    private static long findWay(int index, int remaining) {
        if (remaining == 0) return 1;
        if (remaining < 0 || index == memoization.length) return 0;

        if (memoization[index][remaining] != -1) return memoization[index][remaining];

        long include = findWay(index, remaining - possibleCoins[index]);
        long exclude = findWay(index + 1, remaining);

        memoization[index][remaining] = include + exclude;

        return memoization[index][remaining];
    }
}
