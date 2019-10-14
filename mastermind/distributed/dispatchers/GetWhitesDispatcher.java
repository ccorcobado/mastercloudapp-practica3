package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class GetWhitesDispatcher extends Dispatcher {
    
    public GetWhitesDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int index = this.tcpip.receiveNumber();
        this.tcpip.send(((PlayController)this.acceptorController).getWhites(index));
    }
}