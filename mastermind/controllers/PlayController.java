package mastermind.controllers;

import java.util.List;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class PlayController extends AcceptorController {
    
    public PlayController(Session session) {
        super(session);
    }
    
    public abstract Error checkProposedCombination(List<Color> colors);
    
    public abstract void addProposedCombination(List<Color> colors);
   
    public abstract boolean isWinner();

    public abstract boolean isLooser();
    
    public abstract void undo();

    public abstract void redo();

    public abstract boolean undoable();

    public abstract boolean redoable();
    
    public abstract void next();
    
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }  
}