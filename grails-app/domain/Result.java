public class Result {
    private ResultType type;
    private String message;

    public Result(ResultType type, String message) {
        this.type = type;
        this.message = message;
    }

    public boolean isSuccess() {
        return type.isSuccess();
    }

    public boolean isFailed() {
        return type.isFailed();
    }

    public String getMessage() {
        return message;
    }
}
