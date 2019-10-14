package mastermind.distributed;

import mastermind.distributed.dispatchers.DispatcherPrototype;

public class MastermindServer {
    
    private final DispatcherPrototype dispatcherPrototype;
    private final LogicImplementationServer logicServer;

    private MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicImplementationServer();
        this.logicServer.createDispatchers(this.dispatcherPrototype);
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

    private void serve() {
        this.dispatcherPrototype.serve();
    }
}