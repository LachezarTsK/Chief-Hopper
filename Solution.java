import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfBuildings = scanner.nextInt();
    int[] heights = new int[numberOfBuildings];

    for (int i = 0; i < numberOfBuildings; i++) {
      heights[i] = scanner.nextInt();
    }
    scanner.close();

    int result = find_minStartingEnergy(heights);
    System.out.println(result);
  }

  /**
   * Calculates the minimum starting energy required for the bot, so that it can jump to the top of
   * every building on the path.
   *
   * The method calculates this value by starting from the minimum energy that would be required
   * for the last building, and then in this manner works, it works its way backwards to the first
   * building.
   *
   * @return An integer, representing the minimum starting energy needed to jumpt to the top of all
   *         buildings on the path.
   */
  private static int find_minStartingEnergy(int[] heights) {

    int minEnergy = 0;
    for (int i = heights.length - 1; i >= 0; i--) {

      /**
       * A more efficient alternative to '(int) Math.ceil((double)(energy + heights[i] + 1) / 2)'.
       * Since energy can take only integer values, the current energy, if need be, has to be
       * rounded up, so that it is enough for a jump to the top of the next building.
       */
      minEnergy = (minEnergy + heights[i] + 1) / 2;
    }

    return minEnergy;
  }
}
