package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.ProposalView;

public class OptionProposeCombination extends OptionPlay {

    public OptionProposeCombination(PlayController playController) {
        super("Propose Combination", playController);
    }
    
    @Override
    public void execute() {
        new ProposalView().interact(this.playController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}