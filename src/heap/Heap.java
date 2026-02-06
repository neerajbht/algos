package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    // leftChild = heap[2 * i]
    // rightChild = heap[(2 * i) + 1]
    // parent = heap[i // 2]
    List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
        heap.add(0);

    }

    /*
     * add to the bottom and then move up
     * 
     */
    public void push(int val) {
        // start by gettin last postion
        int index = heap.size() - 1;

        // swim up ....percolate up
        /**
         * // leftChild = heap[2 * i]
         * // rightChild = heap[(2 * i) + 1]
         * // parent = heap[i // 2]
         * compaare heap with parent , while value at index is less than parent position
         * we swap values
         * we keep on moving value up to parent
         */
        while (index > 1 && heap.get(index) < heap.get(index / 2)) {
            int temp = heap.get(index / 2);
            heap.set(index, heap.get(index / 2));
            heap.set(index / 2, temp);
            index = index / 2;
        }

    }

    public int pop() {
        if (heap.size() == 1)
            return heap.get(0);
        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1);
        }
        // 1 we get from top always
        int res = heap.get(1);
        // 2 move last root value to top
        heap.set(1, heap.get(heap.size() - 1));

        int index = 1;
        /**
         * step 3 percolate down...sink
         * // leftChild = heap[2 * i]
         * // rightChild = heap[(2 * i) + 1]
         * // parent = heap[i // 2]
         */
        // leftchild index is less than size
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        /// we move donw 2 position at a time
        while (leftIndex < heap.size()) {

            if (rightIndex < heap.size() &&

            // so we can swap with either on right side or left side
            // base condition is current value is > right or left
            // so if we see right is less than left --- swap right
            // else swap left

            // right has to be less than left
                    heap.get(rightIndex) < heap.get(leftIndex) &&
                    // and if value at index is > then ritght then we swap
                    heap.get(index) > heap.get(rightIndex)) {
                // Swap right child
                int tmp = heap.get(index);
                heap.set(index, heap.get(rightIndex));
                heap.set(rightIndex, tmp);
                index = rightIndex;
                // else we try to swap with left
            } else if (heap.get(index) > heap.get(leftIndex)) {
                // Swap left child
                int tmp = heap.get(index);
                heap.set(index, heap.get(leftIndex));
                heap.set(leftIndex, tmp);
                index = leftIndex;
            } else {
                break;
            }

        }

        return res;
    }

}
