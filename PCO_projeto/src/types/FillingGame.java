package types;
import types.Table;

public interface FillingGame {

    /**
     * Play the game by interacting with the bottle at position (x, y).
     *
     * @param x The x-coordinate of the bottle.
     * @param y The y-coordinate of the bottle.
     */
    public void play(int x, int y);

    /**
     * Check if the current round is finished.
     *
     * @return true if the round is finished, false otherwise.
     */
    public boolean isRoundFinished();

    /**
     * Start a new round of the game.
     */
    public void startNewRound();

    /**
     * Provide help or instructions to the player.
     */
    public void provideHelp();

    /**
     * Get the filling (liquid) at the top of the bottle at position x.
     *
     * @param x The x-coordinate of the bottle.
     * @return The filling at the top of the bottle.
     */
    public Filling top(int x);

    /**
     * Check if a single filling (liquid) is present in the bottle at position x.
     *
     * @param x The x-coordinate of the bottle.
     * @return true if a single filling is present, false otherwise.
     */
    public boolean singleFilling(int x);

    /**
     * Get the current score of the game.
     *
     * @return The game score.
     */
    public int score();
}

