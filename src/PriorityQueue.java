/**
 * The PriorityQueue class represents a priority queue data structure implemented using an array.
 * It supports insertion, removal, and retrieval of the minimum value in O(n) time complexity.
 */
public class PriorityQueue {
    private int maxSize;
    private int nItems;
    private long[] queueArray;

    /**
     * Constructs a PriorityQueue object with a specified maximum size.
     *
     * @param maxSize The maximum size of the priority queue.
     */
    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        nItems = 0;
    }

    /**
     * Inserts an item into the priority queue while maintaining the order.
     *
     * @param item The item to be inserted.
     */
    public void insert(long item) {
        int j;

        if (nItems == 0) {
            queueArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queueArray[j]) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j + 1] = item;
            nItems++;
        }
    }

    /**
     * Removes and returns the minimum value from the priority queue.
     *
     * @return The minimum value in the priority queue.
     */
    public long remove() {
        return queueArray[--nItems];
    }

    /**
     * Retrieves the minimum value from the priority queue without removing it.
     *
     * @return The minimum value in the priority queue.
     */
    public long peekMin() {
        return queueArray[nItems - 1];
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * Checks if the priority queue is full.
     *
     * @return true if the priority queue is full, false otherwise.
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }

    /**
     * The main method demonstrates the usage of the PriorityQueue class.
     */
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);

        pq.insert(100);
        pq.insert(200);
        pq.insert(50);
        pq.insert(300);
        pq.insert(350);

        while (!pq.isEmpty()) {
            long item = pq.remove();
            System.out.println(item + "");
        }
    }
}

