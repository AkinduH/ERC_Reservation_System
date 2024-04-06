// TextFile class represents a text file with a filename, file type, and file content.
public class TextFile {
    private String fileName; // Stores the filename of the text file
    private String fileType; // Stores the file type of the text file
    private String fileContent; // Stores the content of the text file

    public TextFile(String fileName, String fileType, String fileContent) { // Constructor to initialize the text file
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileContent = fileContent;
    }

    // Getters
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