package mastermind.distributed.dispatchers;

import mastermind.controllers.StartController;

public class StartNameDispatcher extends Dispatcher {

    public StartNameDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        String title = this.tcpip.receiveLine();
        ((StartController) this.acceptorController).start(title);
    }
}
