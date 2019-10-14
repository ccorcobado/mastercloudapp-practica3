package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;

public class MastermindStandalone extends ConsoleMastermind {
    
    public MastermindStandalone() {
        super();
    }
    
    public static void main(String[] args) {
        new MastermindStandalone().play();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation();
    }
}