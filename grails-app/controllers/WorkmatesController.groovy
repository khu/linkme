class WorkmatesController {

  def allowedMethods = [add: 'POST', index: 'GET']

  def index = {
    render(view: 'index', model: [workmates: Employees.get()])
  }

}
