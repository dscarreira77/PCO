package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class FinalScoringFillingGame extends AbstractFillingGame {

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = 0; // Set the score to 0 by default
    }

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize, int score) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = score; // Set the score to the given value
    }

    @Override
    public void updateScore() {
        // Your implementation based on the game rules
        if (isRoundFinished()) {
            int moves = jogadas(); // Assuming the number of moves is captured by jogadas() method
            if (moves <= 10) {
                this.score += 1000;
            } else if (moves <= 15) {
                this.score += 500;
            } else if (moves <= 25) {
                this.score += 200;
            } else {
                this.score -= 100;
            }
        }
    }

    @Override
    public int score() {
        return this.score;
    }

    @Override
    public String toString() {
        // Your implementation for describing the game state
        return "FinalScoringFillingGame state";
    }

}

