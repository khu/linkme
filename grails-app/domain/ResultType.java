public enum ResultType {
    ALEADY_HAD, FAILED, SUCCESSFUL;

    public boolean isSuccess() {
        return this.equals(SUCCESSFUL);
    }

    public boolean isFailed() {
        return this.equals(FAILED);
    }
}
