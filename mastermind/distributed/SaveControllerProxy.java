package mastermind.distributed;

import mastermind.controllers.SaveController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIPManager;
import mastermind.models.Session;

public class SaveControllerProxy extends SaveController {
    private final TCPIPManager tcpip;

    public SaveControllerProxy(Session session, TCPIPManager tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void save(String name) {
        this.tcpip.send(FrameType.SAVENAMED.name());
        this.tcpip.send(name);
    }

    @Override
    public void save() {
        this.tcpip.send(FrameType.SAVE.name());
    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.NEXT.name());
    }

    @Override
    public boolean hasName() {
        this.tcpip.send(FrameType.HASNAME.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean exists(String name) {
        this.tcpip.send(FrameType.EXISTS.name());
        this.tcpip.send(name);
        return this.tcpip.receiveBoolean();
    }
}
