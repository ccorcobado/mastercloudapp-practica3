package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.SaveController;
import mastermind.views.View;
import mastermind.views.console.menu.MenuGame;
import mastermind.views.console.menu.MenuStart;

public class ConsoleView extends View {

    private final StartView startView;
    private final SaveView saveView;
    private final ResumeView resumeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.saveView = new SaveView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
        new MenuStart(startController).execute();
    }

    @Override
    public void visit(PlayController playController) {
        new MenuGame(playController).execute();
    }
    
    @Override
    public void visit(SaveController saveController) {
        this.saveView.interact(saveController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);
    }
}