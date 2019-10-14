package mastermind.controllers;

import mastermind.models.Session;

public abstract class StartController extends AcceptorController {
    
    public StartController(Session session) {
        super(session);
    }

    public abstract void start();
    
    public abstract void start(String name);
    
    public abstract String[] getSavedGamesName();

    @Override
    public void accept(ControllerVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}