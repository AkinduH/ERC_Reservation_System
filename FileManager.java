// FileManager class manages the loading and retrieval of text files.
// It loads the hardcoded file paths, reads the file content, and creates TextFile objects.
// The getNextFile() method returns the next available TextFile object from the list and removes it from the list.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<TextFile> textFiles; // List to store TextFile objects

    public FileManager() { // Constructor for FileManager
        textFiles = new ArrayList<>();
        loadFiles();
    }

    private void loadFiles() { // Method to load files
        // Hardcoded file paths
        String[] filePaths = {
                "file1.txt", "file2.txt", "file3.txt", "file4.txt",
                "file5.pdf", "file6.txt", "file7.png"
        };

        for (String filePath : filePaths) { // Iterate over file paths
            String fileType = filePath.substring(filePath.lastIndexOf(".") + 1); // Extract file type from file path
            ReadAFile(filePath, fileType); // Read the file and create a TextFile object
        }
    }

    private void ReadAFile(String filePath, String fileType) { // Method to read a file and create a TextFile object
        StringBuilder content = new StringBuilder(); // StringBuilder to store file content
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Open file for reading
            String line;
            while ((line = reader.readLine()) != null) { // Read file line by line
                content.append(line).append("\n"); // Append line to content
            }
            String fileContent = content.toString(); // Convert StringBuilder to String
            TextFile textFile = new TextFile(filePath, fileType, fileContent); // Create TextFile object
            textFiles.add(textFile); // Add TextFile object to the list
        } catch (IOException e) { // Catch IOException
            System.out.println("Error reading file: " + filePath); // Print error message
        }
    }

    public synchronized TextFile getNextFile() { // Method to get the next available TextFile object
        if (textFiles.isEmpty()) { // Check if the list is empty
            return null; // Return null if the list is empty
        }
        TextFile file = textFiles.remove(0); // Remove and retrieve the first TextFile object from the list
        return file;
    }
}