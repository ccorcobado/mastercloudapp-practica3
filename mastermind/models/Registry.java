package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    
    private List<SnapShot> snapShotList;
    private final Origin origin;
    private int undoCount;

    public Registry(Origin origin) {
        this.origin = origin;
        this.undoCount = 0;
        this.snapShotList = new ArrayList<>();
        this.snapShotList.add(this.undoCount, this.origin.createSnapShot());
    }

    public void registry() {
        for (int i = 0; i < this.undoCount; i++) {
            this.snapShotList.remove(0);
        }
        this.undoCount = 0;
        this.snapShotList.add(this.undoCount, this.origin.createSnapShot());
    }

    public void undo(Game game) {
        this.undoCount++;
        game.restore(this.snapShotList.get(this.undoCount));
    }

    public void redo(Game game) {
        this.undoCount--;
        game.restore(this.snapShotList.get(this.undoCount));
    }

    public boolean undoable() {
        return this.undoCount < this.snapShotList.size() - 1;
    }

    public boolean redoable() {
        return this.undoCount >= 1;
    }

    public void reset() {
        this.snapShotList = new ArrayList<>();
        if (undoCount <= this.snapShotList.size())
            this.snapShotList.add(undoCount, this.origin.createSnapShot());
        this.undoCount = 0;
    }
}