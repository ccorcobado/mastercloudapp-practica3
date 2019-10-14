package mastermind.models;

public interface Origin {
    SnapShot createSnapShot();
    void restore(SnapShot memento);
}
