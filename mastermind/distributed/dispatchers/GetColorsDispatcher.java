package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class GetColorsDispatcher extends Dispatcher {
    
    public GetColorsDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int index = this.tcpip.receiveNumber();
        this.tcpip.send(((PlayController)this.acceptorController).getColors(index));
    }
}
