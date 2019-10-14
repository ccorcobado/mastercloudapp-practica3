package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.SnapShotView;

public class OptionNewGame extends OptionStart {
    
    public OptionNewGame(StartController startController) {
        super("Start a new game", startController);
    }
    
    @Override
    public void execute() {
        this.startController.start();

        new SnapShotView().interact(this.startController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
