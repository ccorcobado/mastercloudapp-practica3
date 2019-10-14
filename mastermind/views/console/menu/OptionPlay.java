package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.utils.Command;

public abstract class OptionPlay extends Command {
    protected PlayController playController;

    protected OptionPlay(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }
}