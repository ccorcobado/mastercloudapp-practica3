package mastermind.models;

import java.util.List;
import mastermind.types.Color;

public interface Session {
    
    public void resume();

    public void next();

    public StateValue getValueState();
    
    public int getWidth();
    
    public boolean isWinner();
    
    public boolean isLooser();
    
    public int getAttempts();
    
    public List<Color> getColors(int position);
    
    public int getBlacks(int position);

    public int getWhites(int position);
    
    public void addProposedCombination(List<Color> proposedCombination);

    public boolean undoable();

    public boolean redoable();

    public void undo();

    public void redo();
    
    String getName();

    void setName(String title);
}
