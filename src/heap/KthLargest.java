package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    /* o(nlogn) O(1) space */
    public int findKthLargestSort(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    /* o(nlogn) O(k) space */

    public int findKthLargest(int[] nums, int k) {
        /**  */
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int a : nums) {
            heap.offer(a);
            if (heap.size() > k) {
                return heap.poll(); /// note poll is compute intensive ...so we may not want to do it

            }
        }
        return heap.peek();

    }

    /*** most optimal */
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];

        // Random pivot selection to ensure O(n) performance
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);

        pivotIndex = partition(nums, left, right, pivotIndex);

        if (pivotIndex == k) {
            return nums[k];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums, pivot_index, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}