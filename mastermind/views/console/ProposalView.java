package mastermind.views.console;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {

    public void interact(PlayController playController) {
        Error error;
        do {
            List<Color> colors = new ProposedCombinationView(playController).read();
            error = playController.checkProposedCombination(colors);
            if (error != null) 
                new ErrorView(error).writeln();
            else
                playController.addProposedCombination(colors);
        } while (error != null);
        new SnapShotView().interact(playController);
        if (playController.isWinner()) {
            this.console.writeln(MessageView.WINNER.getMessage());
        } else if (playController.isLooser()) {
            this.console.writeln(MessageView.LOOSER.getMessage());
        }
    }
}
