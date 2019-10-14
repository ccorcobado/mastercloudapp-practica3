package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.SnapShotView;

public class OptionUndo extends OptionPlay {
    
    public OptionUndo(PlayController playController) {
        super("Undo previous Proposal", playController);
    }
    
    @Override
    public void execute() {
        this.playController.undo();
        new SnapShotView().interact(this.playController);
    }

    @Override
    public boolean isActive() {
        return this.playController.undoable();
    }
}