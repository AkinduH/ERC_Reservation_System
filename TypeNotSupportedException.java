// TypeNotSupportedException is a custom exception thrown when an unsupported file type is encountered.
public class TypeNotSupportedException extends Exception {
    public TypeNotSupportedException(String message) {
        super(message);
    }
}