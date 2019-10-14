package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class IsLooserDispatcher extends Dispatcher {
    
    public IsLooserDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).isLooser());
    }
}
