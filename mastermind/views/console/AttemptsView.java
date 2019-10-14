package mastermind.views.console;

import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

    public void writeln(int attempts) {
        this.console.writeln();
        this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
                "" + attempts));
    }
}