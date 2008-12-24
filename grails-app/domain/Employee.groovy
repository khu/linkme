import ymsg.network.Session
import ymsg.network.YahooUser

class Employee {
    protected String realName;
    protected String yahooId;

    public Employee() {
    }

    public Employee(String realName, String yahooId) {
        this.realName = realName;
        this.yahooId = yahooId;
    }



  def static Employee get(String realName, String yahooId) {
        if (Util.isEmpty(yahooId)) {
            return new NullEmployee(realName, yahooId);
        } else {
            return new Employee(realName, yahooId);
        }
    }

    public String toString() {
        return realName + "(" + yahooId + ")";
    }

    public boolean isSelf(String userName) {
        return userName.equals(yahooId);
    }

    public Boolean isFriend(Session session) {
        YahooUser user = session.getUser(yahooId);
        return user != null && user.isFriend();
    }

    Result delete(Session session) {
        session.removeFriend(yahooId, null);
    }

    Result invite(Session session) {
        try {
            session.addFriend(yahooId, "ThoughtWorksChina");
            return new Result(ResultType.SUCCESSFUL, "Successfully invited " + realName + "");
        } catch (Exception e) {
            return new Result(ResultType.FAILED, "Failed to invit " + realName + "( " + yahooId + ")");
        };
    }
}