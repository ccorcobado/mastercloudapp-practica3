package mastermind.controllers.implementation;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.controllers.RedoController;
import mastermind.controllers.UndoController;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayControllerImplementation extends PlayController {
    
    private final ProposalController proposalController;
    private final UndoController undoController;
    private final RedoController redoController;
    
    public PlayControllerImplementation(Session session) {
        super(session);
        
        this.proposalController = new ProposalController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }
    
    @Override
    public int getAttempts() {
        return this.proposalController.getAttempts();
    }
    
    @Override
    public void addProposedCombination(List<Color> colors) {
        this.proposalController.addProposedCombination(colors);
    }
            
    @Override
    public Error checkProposedCombination(List<Color> colors) {
        return this.proposalController.checkProposedCombination(colors);
    }
    
    @Override
    public boolean isWinner() {
        return this.proposalController.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.proposalController.isLooser();
    }
    
    @Override
    public void undo() {
        this.undoController.undo();
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }
    
    @Override
    public void next() {
        this.session.next();
    }
}