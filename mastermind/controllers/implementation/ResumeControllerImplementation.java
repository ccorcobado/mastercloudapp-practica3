package mastermind.controllers.implementation;

import mastermind.controllers.*;
import mastermind.models.Session;

public class ResumeControllerImplementation extends ResumeController {

    public ResumeControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void resume(boolean newGame) {
        if (newGame) 
            this.session.resume();
         else 
            this.session.next();        
    }
}