package mastermind.controllers;

import mastermind.models.Session;

public class ExitController extends Controller {

    public ExitController(Session session) {
        super(session);
    }

    public void next() {
        this.session.next();
    }
}
