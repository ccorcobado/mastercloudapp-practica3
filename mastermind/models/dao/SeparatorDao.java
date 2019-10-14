package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class SeparatorDao implements Dao {
    
    @Override
    public void save(FileWriter fileWriter) {
        try {
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void load(BufferedReader bufferedReader) {
        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
