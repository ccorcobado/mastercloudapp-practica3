package mastermind.distributed.dispatchers;

import mastermind.controllers.SaveController;

public class ExistsDispatcher extends Dispatcher {

    public ExistsDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((SaveController) this.acceptorController).hasName());
    }
}
