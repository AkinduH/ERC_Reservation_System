// Printer class simulates the behavior of a printer.
// It continuously retrieves PrintJob objects from the shared queue and "prints" them by printing the filename and file content.

import java.util.concurrent.BlockingQueue;

public class Printer extends Thread {
    private BlockingQueue<PrintJob> sharedQueue; // Shared queue for communication with computers

    public Printer(BlockingQueue<PrintJob> sharedQueue) { // Constructor
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() { // Run method for the thread
        while (true) { // Loop indefinitely
            try {
                PrintJob job = sharedQueue.take(); // Take a PrintJob object from the shared queue
                System.out.println("Printing job: " + job.getFileName()); // Print the filename of the print job
                System.out.println(job.getFileContent()); // Print the content of the print job
                // Simulate printing process
            } catch (InterruptedException e) {
                System.out.println("Printer thread interrupted."); // Print a message if the thread is interrupted
            }
        }
    }
}
