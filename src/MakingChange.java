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
    public static long countWays(int target, int[] coins) {
        Arrays.sort(coins);

        int length = coins.length;

        for (int i = length - 1; i >= 0; i--) {

        }
        return 0;
    }

    private static long wayPath(int target, int[] coins) {

    }
}
