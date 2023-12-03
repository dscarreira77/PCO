package types;
import types.Table;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class FinalScoringFillingGame extends AbstractFillingGame {

	public FinalScoringFillingGame(Table table) {
		this.table = table;
		this.score = 0;
    }

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = 0; 
    }

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize, int score) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = score; 
    }

    @Override
    public void updateScore() {
        // Your implementation based on the game rules
        if (areAllFilled()) {
            int moves = table.nrMoves; //pesquisar chamada de vairavel definida em table
            if (moves < 10) {
                this.score += 1000;
            } else if (moves >= 10 && moves <= 15) {
                this.score += 500;
            } else if (moves > 15 && moves <= 25) {
                this.score += 200;
            } else {
                this.score = 0;
            }
        } else {
			this.score -= 100;
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

