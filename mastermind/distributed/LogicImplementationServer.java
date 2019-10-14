package mastermind.distributed;

import mastermind.controllers.implementation.LogicImplementation;
import mastermind.distributed.dispatchers.AddProposeCombinationDispatcher;
import mastermind.distributed.dispatchers.CheckProposeCombinationDispatcher;
import mastermind.distributed.dispatchers.GetCombinationLengthDispatcher;
import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.distributed.dispatchers.ExistsDispatcher;
import mastermind.distributed.dispatchers.NextDispatcher;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.GetAttemptsDispatcher;
import mastermind.distributed.dispatchers.GetBlacksDispatcher;
import mastermind.distributed.dispatchers.GetColorsDispatcher;
import mastermind.distributed.dispatchers.GetTitleDispatcher;
import mastermind.distributed.dispatchers.GetWhitesDispatcher;
import mastermind.distributed.dispatchers.HasNameDispatcher;
import mastermind.distributed.dispatchers.IsLooserDispatcher;
import mastermind.distributed.dispatchers.IsWinnerDispatcher;
import mastermind.distributed.dispatchers.RedoDispatcher;
import mastermind.distributed.dispatchers.RedoableDispatcher;
import mastermind.distributed.dispatchers.ResumeDispatcher;
import mastermind.distributed.dispatchers.SaveDispatcher;
import mastermind.distributed.dispatchers.SaveNamedDispatcher;
import mastermind.distributed.dispatchers.SetTitleDispatcher;
import mastermind.distributed.dispatchers.StartDispatcher;
import mastermind.distributed.dispatchers.StateDispatcher;
import mastermind.distributed.dispatchers.GetSavedFilesNameDispatcher;
import mastermind.distributed.dispatchers.StartNameDispatcher;
import mastermind.distributed.dispatchers.UndoDispatcher;
import mastermind.distributed.dispatchers.UndoableDispatcher;

public class LogicImplementationServer extends LogicImplementation {
    
    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_COMBINATION_LENGTH, new GetCombinationLengthDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_ATTEMPTS, new GetAttemptsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ADD_PROPOSE_COMBINATION, new AddProposeCombinationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.CHECK_PROPOSE_COMBINATION, new CheckProposeCombinationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_BLACKS, new GetBlacksDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_WHITES, new GetWhitesDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_COLORS, new GetColorsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinnerDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_LOOSER, new IsLooserDispatcher(this.playControllerImplementation));
        
        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVENAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_TITLE, new GetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SET_TITLE, new SetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_SAVEDGAMES, new GetSavedFilesNameDispatcher(this.startControllerImplementation));
    }
}
