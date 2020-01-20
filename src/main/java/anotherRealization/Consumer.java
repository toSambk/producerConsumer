package anotherRealization;

import java.util.Random;

public class Consumer implements Runnable {

    private final Buffer<Integer> buffer;

    public Consumer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {

                synchronized (buffer) {

                    System.out.println("Consumer: current buffer size is " + buffer.getSize());

                    if (buffer.isEmpty()) {
                        System.out.println("Consumer: buffer is empty. Waiting...");
                        buffer.wait();
                        System.out.println("Consumer: stop waiting.");
                    }

                    System.out.println("Consumer: getting element " + buffer.getFirstElement());

                    buffer.notify();

                }

                Thread.sleep(new Random().nextInt(3000));

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
