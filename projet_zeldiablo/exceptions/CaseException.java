package exceptions;

public class CaseException extends IllegalArgumentException {

    public CaseException() {
        super();
    }

    public CaseException(String msg) {
        super(msg);
    }
}
