package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.types.Color;

public class GameDao implements Dao {
    private final Game game;

    public GameDao(Game game) {
        this.game = game;
    }

    @Override
    public void save(FileWriter fileWriter) {
        new SecretCombinationDao(this.game.getSecretCombination()).save(fileWriter);
        new AttemptsDao(this.game).save(fileWriter);        
        for (int i = 0; i < this.game.getAttempts(); i++) {
            new ProposeCombinationDao(this.game.getProposedCombination(i)).save(fileWriter);
            new SeparatorDao().save(fileWriter);
            new ResultDao(this.game.getResult(i)).save(fileWriter);
            new SeparatorDao().save(fileWriter);
        }
    }
    
    @Override
    public void load(BufferedReader bufferedReader) {
        new SecretCombinationDao(this.game.getSecretCombination()).load(bufferedReader);
        AttemptsDao attemptsDao = new AttemptsDao(this.game);
        attemptsDao.load(bufferedReader);
        for (int i = 0; i < this.game.getAttempts(); i++) {                    ;
            new ProposeCombinationDao(this.game.getProposedCombination(i)).load(bufferedReader);            
            new ResultDao(this.game.getResult(i)).load(bufferedReader);
        }
    }
}
