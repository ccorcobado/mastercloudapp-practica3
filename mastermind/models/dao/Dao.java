package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;

public interface Dao {
    void save(FileWriter fileWriter);
    void load(BufferedReader bufferedReader);
}