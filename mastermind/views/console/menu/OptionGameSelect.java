package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.SaveView;

public class OptionGameSelect extends OptionStart {

    public OptionGameSelect(String title, StartController startController) {
        super(title, startController);
    }

    @Override
    public void execute() {
        new SaveView().interact(this.startController, this.title);
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}
