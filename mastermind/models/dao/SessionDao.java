package mastermind.models.dao;

public interface SessionDao {
    public void save();
    public void save(String name);
    public void load(String name);
    public String[] getSavedGamesNames();
    public boolean exists(String name);
}
