// SharedQueue class encapsulates the blocking queue used for communication between computers and printers.

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SharedQueue {
    private BlockingQueue<PrintJob> queue;

    public SharedQueue(int capacity) {
        queue = new LinkedBlockingQueue<>(capacity);
    }

    public BlockingQueue<PrintJob> getQueue() {
        return queue;
    }
}