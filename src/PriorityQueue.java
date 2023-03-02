public class PriorityQueue {
    private int maxSize;
    private int nItems;
    private long[] queueArray;

    public PriorityQueue(int S){
        maxSize= S;
        queueArray= new long[maxSize];
        nItems=0;
    }

    public void insert(long item) {
        int G;

        if (nItems == 0) {
            queueArray[nItems++] = item;
        } else {
            for (G = nItems - 1; G >= 0; G--) {
                if (item > queueArray[G]) {
                    queueArray[G + 1] = queueArray[G];
                } else {
                    break;
                }
            }
            queueArray[G + 1] = item;
            nItems++;
        }
    }

    public long remove(){
        return queueArray[--nItems];
    }

    public long peekMin(){
        return queueArray[nItems-1];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public static void main(String[] args) {
        PriorityQueue PQ= new PriorityQueue(5);

        PQ.insert(100);
        PQ.insert(200);
        PQ.insert(50);
        PQ.insert(300);
        PQ.insert(350);

        while (!PQ.isEmpty()){
            long item= PQ.remove();
            System.out.println(item + "");
        }
    }
}
