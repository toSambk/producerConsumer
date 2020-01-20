package anotherRealization;

import java.util.Random;

public class Producer implements Runnable {

    private final Buffer<Integer> buffer;

    public Producer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int counter = 0;
        try {
            while (true) {

                synchronized (buffer) {
                    System.out.println("Producer: buffer size is " + buffer.getSize());
                    if (buffer.isFull()) {
                        System.out.println("Producer: buffer is full. Waiting...");
                        buffer.wait();
                        System.out.println("Producer: stop waiting");
                    }
                    System.out.println("Producer: adding element " + counter + "...");
                    buffer.add(counter);

                    buffer.notify();
                }
                counter++;
                Thread.sleep(new Random().nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
