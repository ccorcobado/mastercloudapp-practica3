package mastermind.utils;

public class ClosedInterval {

    private final int min;

    private final int max;

    public ClosedInterval(int min, int max) {
        assert min <= max;
        this.min = min;
        this.max = max;
    }

    public boolean includes(int value) {
        return this.min <= value && value <= this.max;
    }
}
