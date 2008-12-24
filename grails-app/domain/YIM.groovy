import ymsg.network.YahooGroup

class YIM {
    private String userName;
    private String password;

    public YIM() {

    }

    public YIM(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



  def static get(String userName, String password) {
        return new YIM(userName, password);
    }

    def inviteFriends(Employees contacts) {
        Results results = new Results();
        ymsg.network.Session ysm = null;
        try {
            ysm = new ymsg.network.Session()
            ysm.login(userName, password);
            for (Employee contact: contacts) {
                if (contact.isSelf(userName)) {
                    continue;
                }
                if (!contact.isFriend(ysm)) {
                    results.add(contact.invite(ysm));
                } else {
                    results.add(new Result(ResultType.ALEADY_HAD, contact.toString() + " is in your friend already."));
                }
            }
        } finally {
            Thread.sleep(5000);
            ysm.logout()
        };
        return results;
    }
}
