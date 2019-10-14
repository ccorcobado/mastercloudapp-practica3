package mastermind.utils;

public abstract class Command {

    protected String title;

    protected Command(String title) {
        this.title = title;
    }

    public abstract void execute();

    public String getTitle() {
        return this.title;
    }

    public abstract boolean isActive();
}