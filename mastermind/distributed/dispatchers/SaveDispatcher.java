package mastermind.distributed.dispatchers;

import mastermind.controllers.SaveController;

public class SaveDispatcher extends Dispatcher {

    public SaveDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        ((SaveController) this.acceptorController).save();
    }
}
