package mastermind.distributed.dispatchers;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.types.Color;

public class CheckProposeCombinationDispatcher extends Dispatcher {
    
    public CheckProposeCombinationDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        List<Color> proposedCombination = this.tcpip.receiveColors();
        this.tcpip.send(((PlayController)this.acceptorController).checkProposedCombination(proposedCombination));
    }
    
}
