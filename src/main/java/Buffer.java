import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private final Object mutex = new Object();
    private List<Integer> buffer = new ArrayList<Integer>();
    private int maxSize;

    public Buffer(int size) {
        this.maxSize = size;
    }

    private boolean isEmpty() {
        return buffer.isEmpty();
    }

    private boolean isFull() {
        return buffer.size() == maxSize;
    }


    public void addElement(int element) throws InterruptedException {

        synchronized (mutex) {

            System.out.println("Buffer size = " + buffer.size());

            if (isFull()) {
                System.out.println("Buffer is full. Current size - " + buffer.size());
                mutex.wait();
                System.out.println("Waiting by producer is finished");
            }

            buffer.add(element);
            mutex.notifyAll();

        }

    }

    public int getFirstElement() throws InterruptedException {

        int result;
        synchronized (mutex) {

            System.out.println("Buffer  size = " + buffer.size());

            if (isEmpty()) {
                System.out.println("Buffer is empty. Current size - " + buffer.size());
                mutex.wait();
                System.out.println("Waiting by consumer is finished");
            }

            result = buffer.get(0);
            buffer.remove(0);
            mutex.notifyAll();

        }

        return result;
    }

}
