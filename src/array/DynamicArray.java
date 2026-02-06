package array;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {
    T[] data;
    int len;
    int capacity;

    public DynamicArray(int size) {
        // validateSize();
        this.capacity = size;
        data = (T[]) new Object[size];
    }

    private int size() {
        return this.len;
    }

    private boolean isEmpty() {
        return this.len == 1;
    }

    private void add(T data) {
        if (this.len == this.capacity) {

            T[] newData = (T[]) new Object[2 * capacity];
            System.arraycopy(data, 0, newData, capacity, len);

        }
    }

}
