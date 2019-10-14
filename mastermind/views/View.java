package mastermind.views;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public void interact(AcceptorController controller) {
        controller.accept(this);
    }
}