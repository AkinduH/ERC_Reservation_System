// Computer class simulates the behavior of a computer.
// It gets the next available TextFile from the FileManager, creates a PrintJob object if the file type is supported, and adds it to the shared queue.
// If the file type is not supported, it throws a TypeNotSupportedException.

import java.util.concurrent.BlockingQueue;
import java.util.Set;

public class Computer extends Thread {
    private BlockingQueue<PrintJob> sharedQueue; // Shared queue for communication with printers
    private Set<String> supportedTypes; // Set of supported file types
    private FileManager fileManager; // FileManager instance for retrieving TextFile objects

    public Computer(BlockingQueue<PrintJob> sharedQueue, Set<String> supportedTypes, FileManager fileManager) { // Constructor
        this.sharedQueue = sharedQueue;
        this.supportedTypes = supportedTypes;
        this.fileManager = fileManager;
    }

    public void run() { // Run method for the thread
        while (true) { // Loop indefinitely
            TextFile textFile = fileManager.getNextFile(); // Get the next available TextFile object
            if (textFile == null) { // If no more files are available
                break; // Exit the loop
            }
            String fileType = textFile.getFileType(); // Get the file type of the TextFile object
            if (supportedTypes.contains(fileType)) { // If the file type is supported
                PrintJob job = new PrintJob(textFile.getFileName(), fileType, textFile.getFileContent()); // Create a PrintJob object
                try {
                    sharedQueue.put(job); // Add the PrintJob object to the shared queue
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted."); // Print a message if the thread is interrupted
                }
            } else { // If the file type is not supported
                try {
                    throw new TypeNotSupportedException(textFile.getFileName() + " file's type not supported : " + fileType); // Throw a TypeNotSupportedException
                } catch (TypeNotSupportedException e) {
                    System.out.println(e.getMessage()); // Print the exception message
                }
            }
        }
    }
}