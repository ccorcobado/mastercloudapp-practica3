package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;

public class NextDispatcher extends Dispatcher {

    public NextDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).next();
    }
}
