package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.dao.SessionDao;

public class StartControllerImplementation extends StartController {
    
    private final SessionDao sessionDao;
    
    public StartControllerImplementation(Session session, SessionDao sessionDao) {
        super(session);
        this.sessionDao = sessionDao;
    }
    
    @Override
    public void start(String name) {
        this.sessionDao.load(name);
    }

    @Override
    public void start() {
        this.session.next();
    }
    
    @Override
    public String[] getSavedGamesName() {
        return this.sessionDao.getSavedGamesNames();
    }
}
