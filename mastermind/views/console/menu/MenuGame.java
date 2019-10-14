package mastermind.views.console.menu;

import mastermind.controllers.PlayController;

public class MenuGame extends Menu {
    
    public MenuGame(PlayController playController) {
        super();
        
        this.addOptionToMenu(new OptionProposeCombination(playController));
        this.addOptionToMenu(new OptionUndo(playController));
        this.addOptionToMenu(new OptionRedo(playController));
        this.addOptionToMenu(new OptionExit(playController));
    }
}
