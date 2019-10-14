package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import mastermind.models.Result;

public class ResultDao implements Dao {
    
    private final Result result;
    
    public ResultDao(Result result) {
        this.result = result;
    }
    
    @Override
    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write(String.valueOf(this.result.getBlacks()));
            fileWriter.write(String.valueOf(this.result.getWhites()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void load(BufferedReader bufferedReader) {
        try {
            String line = bufferedReader.readLine();
            char blacks = (char) line.charAt(0);
            char whites = (char) line.charAt(1);
            this.result.setBlacks(Integer.parseInt(String.valueOf(blacks)));
            this.result.setWhites(Integer.parseInt(String.valueOf(whites)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
