package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.utils.WithConsoleView;

public class SnapShotView extends WithConsoleView {
    
    public void interact(Controller controller) {        
        new AttemptsView().writeln(controller.getAttempts());
        new SecretCombinationView(controller).writeln();
        for (int i = 0; i < controller.getAttempts(); i++) {
            new ProposedCombinationView(controller).write(i);
            new ResultView(controller).writeln(i);
        }
    }
}
