import java.util.List;
import java.util.ArrayList;

public class Results extends ArrayList<Result> {

    public Results allSucceed() {
        Results allFailed = new Results();
        for (Result result : this) {
            if (result.isSuccess()) {
                allFailed.add(result);
            }
        }
        return allFailed;
    }

    public int total() {
        return this.size();
    }

    public Results allFailed() {
        Results allFailed = new Results();
        for (Result result : this) {
            if (result.isFailed()) {
                allFailed.add(result);
            }
        }
        return allFailed;
    }
}
