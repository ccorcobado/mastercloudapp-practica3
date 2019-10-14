package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.SnapShotView;

public class OptionRedo  extends OptionPlay {
    
    public OptionRedo(PlayController playController) {
        super("Redo previous Proposal", playController);
    }
    
    @Override
    public void execute() {
        this.playController.redo();
        new SnapShotView().interact(this.playController);
    }

    @Override
    public boolean isActive() {
        return this.playController.redoable();
    }
}
