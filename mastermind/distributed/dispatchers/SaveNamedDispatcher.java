package mastermind.distributed.dispatchers;

import mastermind.controllers.SaveController;

public class SaveNamedDispatcher extends Dispatcher {

    public SaveNamedDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        String name = this.tcpip.receiveLine();
        ((SaveController) this.acceptorController).save(name);
    }
}