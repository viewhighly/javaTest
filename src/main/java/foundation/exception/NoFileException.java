package foundation.exception;

/**
 * User: gaozhan
 * Date: 1/2/14
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoFileException extends RuntimeException {
    public NoFileException() {}
    public NoFileException(String message) {
        super(message);
    }
}
