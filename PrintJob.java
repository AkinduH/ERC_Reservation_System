// PrintJob class represents a print job with a filename, file type, and file content.
public class PrintJob {
    private String fileName; // Stores the filename of the print job
    private String fileType; // Stores the file type of the print job
    private String fileContent; // Stores the content of the print job

    public PrintJob(String fileName, String fileType, String fileContent) { // Constructor to initialize the print job
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileContent = fileContent;
    }

    // Getters and setters
    public String getFileName() { // Getter method to retrieve the filename
        return fileName;
    }

    public String getFileType() { // Getter method to retrieve the file type
        return fileType;
    }

    public String getFileContent() { // Getter method to retrieve the file content
        return fileContent;
    }
}
