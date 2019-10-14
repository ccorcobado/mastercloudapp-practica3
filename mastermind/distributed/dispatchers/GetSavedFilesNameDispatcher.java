package mastermind.distributed.dispatchers;

import mastermind.controllers.StartController;

public class GetSavedFilesNameDispatcher extends Dispatcher {

    public GetSavedFilesNameDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        String[] names = ((StartController) this.acceptorController).getSavedGamesName();
        this.tcpip.send(names.length);
        for (String name : names) {
            this.tcpip.send(name);
        }
    }
}
