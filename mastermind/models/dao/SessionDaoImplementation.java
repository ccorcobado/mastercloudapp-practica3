package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;

public class SessionDaoImplementation implements SessionDao {
    public static final String EXTENSION = ".mnd";
    public static final String DIRECTORY = System.getProperty("user.dir") + "/partidas";
    private static File directory;
    private final SessionImplementation session;
    private final GameDao gameDao;
    
    static {
        SessionDaoImplementation.directory = new File(SessionDaoImplementation.DIRECTORY);
        if (!SessionDaoImplementation.directory.exists()) {
            SessionDaoImplementation.directory.mkdir();
        }
    }
    
    public SessionDaoImplementation(SessionImplementation session) {
        this.session = session;
        this.gameDao = new GameDao(session.getGame());
    }
    
    @Override
    public void save() {
        this.save(this.session.getName());
    }

    @Override
    public void save(String name) {
        if (!name.endsWith(SessionDaoImplementation.EXTENSION)) {
            name += SessionDaoImplementation.EXTENSION;
        }
        File file = new File(SessionDaoImplementation.directory, name);
        try {
            try (FileWriter fileWriter = new FileWriter(file)) {
                this.gameDao.save(fileWriter);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String name) {
        this.session.setName(name);
        File file = new File(SessionDaoImplementation.directory, name);
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                this.gameDao.load(bufferedReader);
            }
            this.session.resetRegistry();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.session.setValueState(StateValue.IN_GAME);
        if (this.session.isWinner()) {
            this.session.setValueState(StateValue.FINAL);
        }
    }

    @Override
    public String[] getSavedGamesNames() {
        return SessionDaoImplementation.directory.list();
    }

    @Override
    public boolean exists(String name) {
        for (String auxName : this.getSavedGamesNames()) {
            if (auxName.equals(name + SessionDaoImplementation.EXTENSION)) {
                return true;
            }
        }
        return false;
    }
}