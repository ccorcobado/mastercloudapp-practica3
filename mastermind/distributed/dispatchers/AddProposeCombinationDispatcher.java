package mastermind.distributed.dispatchers;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.types.Color;

public class AddProposeCombinationDispatcher extends Dispatcher {
    
    public AddProposeCombinationDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        List<Color> proposedCombination = this.tcpip.receiveColors();
        ((PlayController)this.acceptorController).addProposedCombination(proposedCombination);
    }
}