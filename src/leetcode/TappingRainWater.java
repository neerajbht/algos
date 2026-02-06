package leetcode;

public class TappingRainWater {

  public static void main(String[] args) {
    // water that can be stored at level i is ( maxLeft at level i , maxRight at i )
    // - height(at index i);

    int[] waterLevel = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    System.out.println(TappingRainWater.getTrappedWaterHeight(waterLevel));

  }

  public static int getTrappedWaterHeight(int[] waterLevel) {

    int tappedAmount = 0;
    int leftMax = 0;
    int rightMax = 0;
    int left = 0, right = waterLevel.length - 1;

    while (left < right) {
      if (waterLevel[left] < waterLevel[right]) {
        leftMax = Math.max(leftMax, waterLevel[left]);
        tappedAmount += leftMax - waterLevel[left];
        ++left;
      } else {
        rightMax = Math.max(rightMax, waterLevel[right]);
        tappedAmount += rightMax - waterLevel[right];
        --right;
      }

    }

    return tappedAmount;

  }
}
