package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import mastermind.models.Game;

public class AttemptsDao implements Dao {
    
    private final Game game;
    
    public AttemptsDao(Game game) {
        this.game = game;
    }
    
    @Override
    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write(String.valueOf(this.game.getAttempts()));
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void load(BufferedReader bufferedReader) {
        try {
            String sAttempts = bufferedReader.readLine();
            this.game.setAttempts(Integer.parseInt(sAttempts));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
