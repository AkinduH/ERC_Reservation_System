import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Set the capacity of the shared queue
        int queueCapacity = 5;

        // Create a set of supported file types (txt and pdf)
        Set<String> supportedTypes = new HashSet<>();
        supportedTypes.add("txt");
        supportedTypes.add("pdf");

        // Create a FileManager instance to manage the text files
        FileManager fileManager = new FileManager();

        // Create a SharedQueue instance with the specified capacity
        SharedQueue sharedQueue = new SharedQueue(queueCapacity);

        // Create three Computer objects with the shared queue, supported types, and FileManager
        Computer computer1 = new Computer(sharedQueue.getQueue(), supportedTypes, fileManager);
        Computer computer2 = new Computer(sharedQueue.getQueue(), supportedTypes, fileManager);
        Computer computer3 = new Computer(sharedQueue.getQueue(), supportedTypes, fileManager);

        // Start the three Computer threads
        computer1.start();
        computer2.start();
        computer3.start();

        // Create two Printer objects with the shared queue
        Printer printer1 = new Printer(sharedQueue.getQueue());
        Printer printer2 = new Printer(sharedQueue.getQueue());

        // Start the two Printer threads
        printer1.start();
        printer2.start();
    }
}