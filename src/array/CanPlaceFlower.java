package array;

public class CanPlaceFlower {

    public static void main(String[] rgs) {
        int[] flowerbed = { 1, 0, 0, 0, 0, 0, 1 };
        CanPlaceFlower cp = new CanPlaceFlower();

        System.out.println(cp.canPlaceFlowers(flowerbed, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty.
            if (flowerbed[i] == 0) {
                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0); // i=0 to check if first postion has 0
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0); // i=len -1 to check if
                                                                                                 // 0 is at last
                                                                                                 // poistion

                // If both plots are empty, we can plant a flower here.
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}
