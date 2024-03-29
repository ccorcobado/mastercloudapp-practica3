package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;

public abstract class Combination {

    private static final int WIDTH = 4;

    protected List<Color> colors;

    protected Combination() {
        this.colors = new ArrayList<>();
    }

    public List<Color> getColors() {
        return this.colors;
    }
    
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
    
    public static int getWidth() {
        return Combination.WIDTH;
    }
}