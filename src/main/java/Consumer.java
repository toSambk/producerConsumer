import java.util.Random;

public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                int firstElement = 0;

                firstElement = buffer.getFirstElement();

                System.out.println("Consumer: Extracting element successful - " + firstElement);
                Thread.sleep(new Random().nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
