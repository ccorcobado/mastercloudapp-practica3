package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;
import mastermind.controllers.Controller;
import mastermind.types.Color;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposedCombinationView extends WithConsoleView {

    private final Controller controller;

    public ProposedCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void write(int position) {
        List<Color> colors = this.controller.getColors(position);
        for (Color color : colors) {
            new ColorView(color).write();
        }
    }

    public List<Color> read() {
        String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < characters.length(); i++) {
            colors.add(ColorView.getInstance(characters.charAt(i)));
        }
        return colors;
    }
}