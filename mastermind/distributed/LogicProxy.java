package mastermind.distributed;

import mastermind.controllers.Logic;
import mastermind.distributed.dispatchers.TCPIPManager;
import mastermind.models.StateValue;

public class LogicProxy extends Logic {
    
    private final TCPIPManager tcpip;

    public LogicProxy() {
        this.tcpip = TCPIPManager.createClientSocket();
        this.session = new SessionProxy(this.tcpip);
        this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.SAVING, new SaveControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.FINAL, new ResumeControllerProxy(this.session, this.tcpip));
        this.acceptorControllers.put(StateValue.EXIT, null);
    }

    public void close() {
        this.tcpip.close();
    }
}
