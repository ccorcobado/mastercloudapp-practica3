package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.utils.Command;

public abstract class OptionStart extends Command {
    
    protected StartController startController;

    protected OptionStart(String title, StartController startController) {
        super(title);
        this.startController = startController;
    }
}
