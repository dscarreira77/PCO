package types;
import types.Table;
import java.util.Random;

public class FinalScoringFillingGame extends AbstractFillingGame {
    private int initialScore;

    // Constructor without initial score
    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bottleSize) {
        this(symbols, numberOfUsedSymbols, seed, bottleSize, 0);
    }

    // Constructor with initial score
    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bottleSize, int initialScore) {
        super(symbols, numberOfUsedSymbols, seed, bottleSize);
        this.initialScore = initialScore;
        this.userScore = initialScore; // Initialize the user's score with the initial score
    }

    @Override
    protected Bottle getNewBottle() {
        // Implement the logic to generate a new bottle for this specific game
        // For example:
        Filling[] newBottleContents = new Filling[table.getSizeBottles()];
        // Populate newBottleContents with desired logic
        return new Bottle(newBottleContents);
    }

    @Override
    public void updateScore() {
        // Implement the logic to update the user's score for this specific game
        // For example:
        userScore += 10; // Update the score by 10 points after each play
    }

    // Implement other abstract methods or add additional methods as needed
}


