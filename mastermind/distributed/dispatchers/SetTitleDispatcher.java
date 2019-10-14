package mastermind.distributed.dispatchers;

import mastermind.controllers.SaveController;

public class SetTitleDispatcher extends Dispatcher {

    public SetTitleDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        String title = this.tcpip.receiveLine();
        this.acceptorController.setName(title);
    }
}
