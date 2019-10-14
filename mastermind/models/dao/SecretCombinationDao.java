package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mastermind.models.SecretCombination;
import mastermind.types.Color;

public class SecretCombinationDao implements Dao {
    
    private final SecretCombination secretCombination;
    
    public SecretCombinationDao(SecretCombination secretCombination) {
        this.secretCombination = secretCombination;
    }
    
    @Override
    public void save(FileWriter fileWriter) {
        try {
            for (Color color : this.secretCombination.getColors()) {
                fileWriter.write(String.valueOf(color.ordinal()));
            }
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void load(BufferedReader bufferedReader) {
        try {
            String colors = bufferedReader.readLine();
            List<Color> lColors = new ArrayList<>();
            for (int i = 0; i < colors.length(); i++) {
                char cChar = colors.charAt(i);                
                int iColor = Character.getNumericValue(cChar);
                lColors.add(Color.values()[iColor]);
            }
            this.secretCombination.setColors(lColors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
