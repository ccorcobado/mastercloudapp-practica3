package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.SnapShotView;

public class OptionExit extends OptionPlay {
    
    public OptionExit(PlayController playController) {
        super("Exit", playController);
    }
    
    @Override
    public void execute() {
        this.playController.next();
        
        new SnapShotView().interact(this.playController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
