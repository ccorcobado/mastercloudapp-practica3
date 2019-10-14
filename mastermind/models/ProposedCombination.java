package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;

public class ProposedCombination extends Combination implements Copiable {

    public ProposedCombination(List<Color> colors) {
        this.colors = colors;
    }

    public boolean contains(Color color, int position) {
        return this.colors.get(position) == color;
    }

    public boolean contains(Color color) {
        for (Color color1 : this.colors) {
            if (color1 == color) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ProposedCombination copiar() {
        return new ProposedCombination(new ArrayList<>(this.colors));
    }

}
