package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

public class SecretCombinationView extends WithConsoleView {
    private final Controller controller;

    public SecretCombinationView(Controller controller) {
        super();
        this.controller = controller;
    }

    public void writeln() {
        for (int i = 0; i < this.controller.getWidth(); i++) {
            this.console.write(MessageView.SECRET.getMessage());
        }
        this.console.writeln();
    }

}
