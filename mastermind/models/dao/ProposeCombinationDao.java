package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mastermind.models.ProposedCombination;
import mastermind.types.Color;

public class ProposeCombinationDao implements Dao {
    
    private final ProposedCombination proposedCombination;
    
    public ProposeCombinationDao(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }
    
    @Override
    public void save(FileWriter fileWriter) {
        try {
            for (Color color : this.proposedCombination.getColors()) {
                fileWriter.write(String.valueOf(color.ordinal()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void load(BufferedReader bufferedReader) {
        try {
            List<Color> lColors = new ArrayList<>();
            String colors = bufferedReader.readLine();
            for (int i = 0; i < colors.length(); i++) {
                int iColor = Character.getNumericValue(colors.charAt(i));
                lColors.add(Color.values()[iColor]);
            }
            this.proposedCombination.setColors(lColors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ProposedCombination getProposedCombination() {
        return this.proposedCombination;
    }
}
