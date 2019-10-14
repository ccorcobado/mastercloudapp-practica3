package mastermind.controllers.implementation;

import mastermind.controllers.SaveController;
import mastermind.models.Session;
import mastermind.models.dao.SessionDao;

public class SaveControllerImplementation extends SaveController {

    protected final SessionDao sessionDao;
    
    public SaveControllerImplementation(Session session, SessionDao sessionDao) {
        super(session);
        this.sessionDao = sessionDao;
    }
    
    @Override
    public void save(String name) {
        this.sessionDao.save(name);
    }

    @Override
    public void save() {
        this.sessionDao.save();
    }

    @Override
    public void next() {
        this.session.next();
    }

    @Override
    public boolean hasName() {
        return this.session.getName() != null;
    }

    @Override
    public boolean exists(String name) {
        return this.sessionDao.exists(name);
    }
}