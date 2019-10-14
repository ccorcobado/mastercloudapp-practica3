package mastermind.distributed;

import mastermind.controllers.ResumeController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIPManager;
import mastermind.models.Session;

public class ResumeControllerProxy extends ResumeController {
    
    private final TCPIPManager tcpip;

    public ResumeControllerProxy(Session session, TCPIPManager tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume(boolean newGame) {
        this.tcpip.send(FrameType.NEW_GAME.name());
        this.tcpip.send(newGame);
    }
}