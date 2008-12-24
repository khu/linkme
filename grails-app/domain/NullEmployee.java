import ymsg.network.Session;

public class NullEmployee extends Employee {
    public NullEmployee() {
    }

    public NullEmployee(String realName, String yahooId) {
        super(realName, yahooId);
    }

    public Boolean isFriend(Session session) {
        return false;
    }


    public Result invite(Session session) {
        String id = Util.isEmpty(yahooId) ? "Did not provide yahoo Id" : yahooId;
        return new Result(ResultType.FAILED, "Failed to invite " + realName + "( " + id + ")");
    }
}
