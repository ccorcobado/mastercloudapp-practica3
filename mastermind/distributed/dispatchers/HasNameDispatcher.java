package mastermind.distributed.dispatchers;

import mastermind.controllers.SaveController;

public class HasNameDispatcher extends Dispatcher {

    public HasNameDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((SaveController) this.acceptorController).hasName());
    }
}
