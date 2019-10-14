package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.SnapShotView;

public class OptionOpenGame extends OptionStart {
    
    public OptionOpenGame(StartController startController) {
        super("Open a saved game", startController);
    }
    
    @Override
    public void execute() {
        new MenuGames(this.startController).execute();
        
        new SnapShotView().interact(this.startController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
