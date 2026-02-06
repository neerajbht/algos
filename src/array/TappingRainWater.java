package array;

public class TappingRainWater {

  public static void main(String[] args) {
    // water that can be stored at level i is ( maxleftIndex at level i ,
    // maxrightIndex
    // at i )
    // - minHeight(at index i);

    int[] waterLevel = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    System.out.println(TappingRainWater.getTrappedWaterHeight(waterLevel));

  }

  public static int getTrappedWaterHeight(int[] waterLevel) {

    int tappedAmount = 0;
    int leftIndexMax = 0;
    int rightIndexMax = 0;
    int leftIndex = 0, rightIndex = waterLevel.length - 1;
    // int[] waterLevel = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    while (leftIndex < rightIndex) {
      if (waterLevel[leftIndex] < waterLevel[rightIndex]) {
        leftIndexMax = Math.max(leftIndexMax, waterLevel[leftIndex]);
        tappedAmount += leftIndexMax - waterLevel[leftIndex]; // important
        ++leftIndex;
      } else {
        rightIndexMax = Math.max(rightIndexMax, waterLevel[rightIndex]);
        tappedAmount += rightIndexMax - waterLevel[rightIndex]; // important
        --rightIndex;
      }

    }

    return tappedAmount;

  }

  // find area of trapped water
  // Area formula: width × min(left_height, right_height)

  public static int getTrappedWaterArea(int[] heights) {
    int left = 0, right = heights.length - 1;
    int maxArea = 0;

    while (left < right) {
      int width = right - left;
      int minHeight = Math.min(heights[left], heights[right]);
      int area = width * minHeight;

      maxArea = Math.max(maxArea, area);

      if (heights[left] < heights[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxArea;
  }

}
