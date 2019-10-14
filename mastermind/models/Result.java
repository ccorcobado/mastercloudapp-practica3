package mastermind.models;

public class Result implements Copiable{
    private int blacks = 0;
    private int whites = 0;

    public Result(int blacks, int whites) {
        assert blacks >= 0;
        assert whites >= 0;
        this.blacks = blacks;
        this.whites = whites;
    }

    public boolean isWinner() {
        return this.blacks == Combination.getWidth();
    }

    public int getBlacks() {
        return this.blacks;
    }
    
    public void setBlacks(int blacks) {
        this.blacks = blacks;
    }

    public int getWhites() {
        return this.whites;
    }
    
    public void setWhites(int whites) {
        this.whites = whites;
    }

    @Override
    public Result copiar() {
        return new Result(this.blacks, this.whites);
    }
}