package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class GetCombinationLengthDispatcher extends Dispatcher {
    
    public GetCombinationLengthDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getWidth());
    }
}
