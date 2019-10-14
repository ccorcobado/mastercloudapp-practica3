package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class IsWinnerDispatcher extends Dispatcher {
    
    public IsWinnerDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).isWinner());
    }
}
