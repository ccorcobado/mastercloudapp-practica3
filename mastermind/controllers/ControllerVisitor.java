package mastermind.controllers;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(PlayController proposalController);
    
    void visit(SaveController proposalController);

    void visit(ResumeController continueController);
}