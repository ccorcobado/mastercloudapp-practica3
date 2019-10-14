package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class GetBlacksDispatcher extends Dispatcher {
    
    public GetBlacksDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int index = this.tcpip.receiveNumber();
        this.tcpip.send(((PlayController)this.acceptorController).getBlacks(index));
    }
}