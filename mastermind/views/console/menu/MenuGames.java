package mastermind.views.console.menu;

import mastermind.controllers.StartController;

public class MenuGames extends Menu {
    
    public MenuGames(StartController startController) {
        super();
        
        String[] gamesNames = startController.getSavedGamesName();
        for (String title : gamesNames) {
            this.addOptionToMenu(new OptionGameSelect(title, startController));
        }
    }
}