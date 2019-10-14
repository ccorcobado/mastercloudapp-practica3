package mastermind.distributed;

import mastermind.ConsoleMastermind;
import mastermind.controllers.Logic;

public class MastermindClient extends ConsoleMastermind {
    
    public static void main(String[] args) {
        new MastermindClient().play();
    }

    @Override
    protected Logic createLogic() {
        return new LogicProxy();
    }

    @Override
    protected void play() {
        super.play();
        
        ((LogicProxy)this.logic).close();
    }
}
