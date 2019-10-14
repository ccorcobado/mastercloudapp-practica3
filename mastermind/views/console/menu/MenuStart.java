package mastermind.views.console.menu;

import mastermind.controllers.StartController;

public class MenuStart extends Menu {
    
    public MenuStart(StartController startController) {
        super();
        
        this.addOptionToMenu(new OptionNewGame(startController));
        this.addOptionToMenu(new OptionOpenGame(startController));
    }
}
