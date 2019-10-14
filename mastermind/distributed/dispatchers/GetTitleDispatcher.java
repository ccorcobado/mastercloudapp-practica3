package mastermind.distributed.dispatchers;

import mastermind.controllers.SaveController;

public class GetTitleDispatcher extends Dispatcher {

    public GetTitleDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(this.acceptorController.getName());
    }
}