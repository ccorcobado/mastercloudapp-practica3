package mastermind.views.console.menu;

import java.util.ArrayList;
import java.util.List;

import mastermind.utils.ClosedInterval;
import mastermind.utils.Command;
import mastermind.utils.WithConsoleView;

public abstract class Menu extends WithConsoleView {
    
    private static final String OPTION = "----- Choose one option ----";
    private final List<Command> optionsMenu;

    protected Menu() {
        this.optionsMenu = new ArrayList<>();
    }

    public void execute() {
        List<Command> options = new ArrayList<>();
        for (Command option : this.optionsMenu) {
            if (option.isActive()) {
                options.add(option);
            }
        }
        boolean error;
        int option;
        this.console.writeln();
        this.console.writeln(OPTION);
        for (int i = 0; i < options.size(); i++) {
            this.console.writeln((i + 1) + ") " + options.get(i).getTitle());
        }
        
        do {
            error = false;
            
            option = this.console.readInt("") - 1;
            if (!new ClosedInterval(0, options.size() - 1).includes(option)) {
                error = true;
                this.console.writeln("FORMAT ERROR! Enter a integer formatted value.");
            }
        } while (error);
        
        options.get(option).execute();
    }

    protected void addOptionToMenu(Command option) {
        this.optionsMenu.add(option);
    }
}
