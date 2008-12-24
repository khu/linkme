class YIMController {

  def allowedMethods = [add: 'POST',
          index: 'GET']
  def index = {
    render(view: 'add', model: [results: Employees.get()])
  }

  def add = {
    //def messgener = YahooMessenger.get(params.name, params.password);
    //Results results = messgener.inviteFriends(Contacts.get());
    //render(view:'add',model:[results:results])
  }


}
