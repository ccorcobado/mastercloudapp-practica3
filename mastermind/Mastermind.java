package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;

public abstract class Mastermind {
    protected final Logic logic;
    protected final View view;

    protected Mastermind() {
        this.logic = this.createLogic();
        this.view = this.createView();
    }

    protected abstract View createView();
    
    protected abstract Logic createLogic();

    protected void play() {
        AcceptorController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

}
