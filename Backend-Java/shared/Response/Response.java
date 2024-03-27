import java.io.Serializable;

class Response implements Serializable {
    private final boolean success;
    private final String message;

    Response(boolean success) {
        this(success, null);
    }

    Response(boolean success, String message) {
        thsi.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
