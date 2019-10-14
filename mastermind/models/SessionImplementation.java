package mastermind.models;

import java.util.List;
import mastermind.types.Color;

public class SessionImplementation implements Session {
    
    private final State state;
    private final Game game;
    private final Registry registry;
    private String name;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public Game getGame() {
        return this.game;
    }
    
    public void resetRegistry() {
        this.registry.reset();
    }
    
    @Override
    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    @Override
    public void next() {
        this.state.next();
    }

    @Override
    public StateValue getValueState() {
        return this.state.getValueState();
    }
    
    public void setValueState(StateValue value) {
        this.state.setValueState(value);
    }
    
    @Override
    public int getWidth() {
        return this.game.getWidth();
    }
    
    @Override
    public boolean isWinner() {
        return this.game.isWinner();
    }
    
    @Override
    public boolean isLooser() {
        return this.game.isLooser();
    }
    
    @Override
    public int getAttempts() {
        return this.game.getAttempts();
    }
    
    @Override
    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }
    
    @Override
    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.game.getWhites(position);
    }
    
    @Override
    public void addProposedCombination(List<Color> proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
        
        if (this.game.isWinner() || this.game.isLooser()) {
            this.next();
        }
        
        this.registry.registry();
    }

    @Override
    public boolean undoable() {
        return this.registry.undoable();
    }

    @Override
    public boolean redoable() {
        return this.registry.redoable();
    }

    @Override
    public void undo() {
        this.registry.undo(this.game);
    }

    @Override
    public void redo() {
        this.registry.redo(this.game);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String title) {
        this.name = title;
    }
}