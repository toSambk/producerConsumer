package basicRealization;

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

            System.out.println("basicRealization.Buffer size = " + buffer.size());

            while (isFull()) {
                System.out.println("basicRealization.Buffer is full. Current size - " + buffer.size());
                mutex.wait();
                System.out.println("Waiting by producer is finished");
            }

            buffer.add(element);
            mutex.notify();

        }

    }

    public int getFirstElement() throws InterruptedException {

        int result;
        synchronized (mutex) {

            System.out.println("basicRealization.Buffer  size = " + buffer.size());

            while (isEmpty()) {
                System.out.println("basicRealization.Buffer is empty. Current size - " + buffer.size());
                mutex.wait();
                System.out.println("Waiting by consumer is finished");
            }

            result = buffer.get(0);
            buffer.remove(0);
            mutex.notify();

        }

        return result;
    }

}
