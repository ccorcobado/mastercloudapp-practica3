package mastermind.distributed.dispatchers;

import mastermind.controllers.AcceptorController;

public abstract class Dispatcher {

    protected AcceptorController acceptorController;

    protected TCPIPManager tcpip;

    public Dispatcher(AcceptorController acceptorController) {
        this.acceptorController = acceptorController;
    }

    public abstract void dispatch();

    public void associate(TCPIPManager tcpip) {
        this.tcpip = tcpip;
    }
}