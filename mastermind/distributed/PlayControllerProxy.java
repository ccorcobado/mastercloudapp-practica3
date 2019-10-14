package mastermind.distributed;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIPManager;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayControllerProxy extends PlayController {
    
    private final TCPIPManager tcpip;

    public PlayControllerProxy(Session session, TCPIPManager tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public int getAttempts() {
        return this.session.getAttempts();
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        this.session.addProposedCombination(colors);
    }
    
    @Override
    public Error checkProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.CHECK_PROPOSE_COMBINATION.name());
        this.tcpip.send(colors);
        return this.tcpip.receiveError();
    }

    @Override
    public List<Color> getColors(int position) {
        return this.session.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.session.getWhites(position);
    }

    @Override
    public boolean isWinner() {
        return this.session.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.session.isLooser();
    }

    @Override
    public void undo() {
        this.session.undo();
    }

    @Override
    public void redo() {
        this.session.redo();
    }

    @Override
    public boolean undoable() {
        return this.session.undoable();
    }

    @Override
    public boolean redoable() {
        return this.session.redoable();
    }
    
    @Override
    public void next() {
        this.session.next();
    }
}