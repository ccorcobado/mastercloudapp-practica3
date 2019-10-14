package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

public class ResultView extends WithConsoleView {

    private final Controller controller;

    public ResultView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(int i) {
        int blacks = this.controller.getBlacks(i);
        int whites = this.controller.getWhites(i);
        this.console.writeln(MessageView.RESULT.getMessage()
                .replaceFirst("#blacks", "" + blacks)
                .replaceFirst("#whites", "" + whites));
    }

}
