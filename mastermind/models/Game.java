package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;

public class Game implements Origin {

    private static final int MAX_LONG = 10;

    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;
    private int attempts;

    public Game() {
        this.clear();
    }

    public final void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
        this.attempts = 0;
    }

    public void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }
    
    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }
    
    public ProposedCombination getProposedCombination(int index) {
        return this.proposedCombinations.get(index);
    }
    
    public Result getResult(int index) {
        return this.results.get(index);
    }

    public boolean isLooser() {
        return this.attempts == Game.MAX_LONG;
    }

    public boolean isWinner() {
        return this.results.get(this.attempts - 1).isWinner();
    }

    public int getAttempts() {
        return this.attempts;
    }
    
    public void setAttempts(int attempts) {
        this.clear();
        this.attempts = attempts;
        this.proposedCombinations = new ArrayList<>(this.attempts);
        this.results = new ArrayList<>(this.attempts);
        for (int i = 0; i < attempts; i++) {
            this.proposedCombinations.add(new ProposedCombination(null));
            this.results.add(new Result(0, 0));
        }
    }

    public List<Color> getColors(int position) {
        return this.proposedCombinations.get(position).colors;
    }

    public int getBlacks(int position) {
        return this.results.get(position).getBlacks();
    }

    public int getWhites(int position) {
        return this.results.get(position).getWhites();
    }

    public int getWidth() {
        return Combination.getWidth();
    }
    
    @Override
    public SnapShot createSnapShot() {
        SnapShot memento = new SnapShot(this.secretCombination.copiar(), this.attempts);
        
        for (ProposedCombination proposedCombination : this.proposedCombinations)
            memento.addProposedCombination(proposedCombination.copiar());
        
        for (Result result : this.results)
            memento.addResult(result.copiar());
        
        return memento;
    }
    
    @Override
    public void restore(SnapShot memento) {
        this.attempts = memento.getAttempts();
        this.secretCombination = memento.getSecretCombination().copiar();
        
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
        for (int i = 0; i < memento.getAttempts(); i++) {
            this.proposedCombinations.add(memento.getProposedCombination(i).copiar());
            this.results.add(memento.getResult(i).copiar());
        }
    }
}