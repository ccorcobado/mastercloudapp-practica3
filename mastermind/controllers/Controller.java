package mastermind.controllers;

import java.util.List;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;

public abstract class Controller {

    protected Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public int getWidth() {
        return this.session.getWidth();
    }
    
    public int getAttempts() {
        return this.session.getAttempts();
    }
    
    public List<Color> getColors(int position) {
        return this.session.getColors(position);
    }
    
    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.session.getWhites(position);
    }
    
    public StateValue getStateValue() {
        return this.session.getValueState();
    }
    
    public String getName() {
        return this.session.getName();
    }

    public void setName(String name) {
        this.session.setName(name);
    }
}