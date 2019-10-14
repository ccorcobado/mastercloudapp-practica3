package mastermind.distributed;

import mastermind.controllers.StartController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIPManager;
import mastermind.models.Session;

public class StartControllerProxy extends StartController {
    
    private final TCPIPManager tcpip;

    public StartControllerProxy(Session session, TCPIPManager tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void start(String name) {
        this.tcpip.send(FrameType.STARTNAME.name());
        this.tcpip.send(name);
    }
    
    @Override
    public void start() {
        this.tcpip.send(FrameType.START.name());
    }
    
    @Override
    public String[] getSavedGamesName() {
        this.tcpip.send(FrameType.GET_SAVEDGAMES.name());
        int length = this.tcpip.receiveInt();
        String[] names = new String[length];
        for (int i = 0; i < length; i++) {
            names[i] = this.tcpip.receiveLine();
        }
        return names;
    }
}
