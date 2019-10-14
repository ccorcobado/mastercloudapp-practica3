package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class SnapShot {
    private final SecretCombination secretCombination;
    private final List<ProposedCombination> proposedCombinations;
    private final List<Result> results;
    private final int attempts;
    
    public SnapShot(SecretCombination secretCombination, int attempts) {
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
        this.secretCombination = secretCombination;
        this.attempts = attempts;
    }
    
    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }
    
    public ProposedCombination getProposedCombination(int index) {
        return this.proposedCombinations.get(index);
    }
    
    public void addResult(Result result) {
        this.results.add(result);
    }
    
    public Result getResult(int index) {
        return this.results.get(index);
    }
    
    public int getAttempts() {
        return this.attempts;
    }
    
    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }
}
