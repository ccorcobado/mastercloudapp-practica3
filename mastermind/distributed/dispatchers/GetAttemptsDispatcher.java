package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class GetAttemptsDispatcher extends Dispatcher {
    
    public GetAttemptsDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).getAttempts());
    }
}
