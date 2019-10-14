package mastermind.distributed;

import java.util.List;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIPManager;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;

public class SessionProxy implements Session {

    private final TCPIPManager tcpip;

    public SessionProxy(TCPIPManager tcpip) {
        this.tcpip = tcpip;
    }
    
    @Override
    public void resume() {
        this.tcpip.send(FrameType.NEW_GAME.name());
    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.NEXT.name());
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public int getWidth() {
        this.tcpip.send(FrameType.GET_COMBINATION_LENGTH.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.IS_WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.IS_LOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public int getAttempts() {
        this.tcpip.send(FrameType.GET_ATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public List<Color> getColors(int position) {
        this.tcpip.send(FrameType.GET_COLORS.name());
        this.tcpip.send(position);
        return this.tcpip.receiveColors();
    }

    @Override
    public int getBlacks(int position) {
        this.tcpip.send(FrameType.GET_BLACKS.name());
        this.tcpip.send(position);
        return this.tcpip.receiveInt();
    }

    @Override
    public int getWhites(int position) {
        this.tcpip.send(FrameType.GET_WHITES.name());
        this.tcpip.send(position);
        return this.tcpip.receiveInt();
    }

    @Override
    public void addProposedCombination(List<Color> proposedCombination) {
        this.tcpip.send(FrameType.ADD_PROPOSE_COMBINATION.name());
        this.tcpip.send(proposedCombination);
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }
    
    @Override
    public String getName() {
        this.tcpip.send(FrameType.GET_TITLE.name());
        return this.tcpip.receiveLine();
    }

    @Override
    public void setName(String title) {
        this.tcpip.send(FrameType.SET_TITLE.name());
        this.tcpip.send(title);
    }
}