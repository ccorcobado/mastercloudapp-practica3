package mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    STARTNAME,
    STATE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEXT,
    GET_COMBINATION_LENGTH,
    CHECK_PROPOSE_COMBINATION,
    ADD_PROPOSE_COMBINATION,
    GET_ATTEMPTS,
    GET_BLACKS,
    GET_WHITES,
    GET_COLORS,    
    IS_WINNER,
    IS_LOOSER,
    GET_SAVEDGAMES,
    NEW_GAME,
    CLOSE,
    SAVE,
    SAVENAMED,
    HASNAME,
    EXISTS,
    SET_TITLE,
    GET_TITLE;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}