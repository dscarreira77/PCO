package types;
import types.Table;

public interface FillingGame {

    void play(int x, int y);

    boolean isRoundFinished();

    void startNewRound();

    void provideHelp();

    Filling top (int x);

    boolean singleFilling(int x);

    boolean areAllFilled(int x);

    int score();
}

