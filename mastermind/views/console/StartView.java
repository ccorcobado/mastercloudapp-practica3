package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

public class StartView extends WithConsoleView {
    
    public void interact(StartController startController) {
        this.console.writeln(MessageView.TITLE.getMessage());
    }
}
