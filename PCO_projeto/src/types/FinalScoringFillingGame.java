package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class FinalScoringFillingGame extends AbstractFillingGame {
    private Table table;

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = 0;
        this.table = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
    }

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize, int score) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = score; 
        this.table = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
    }

    @Override
    public void updateScore() {
        if (table.areAllFilled()) {
            int moves = table.nrMoves;
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
        return table.toString();
    }

    @Override
    public void play(int x, int y) {
        if(table.singleFilling(x) && !table.isEmpty(x)){
			if(!table.isFull(y) || table.top(x).equals(table.top(y))){
				table.pourFromTo(x, y);
			}
		}
    }

    @Override
    public boolean isRoundFinished() {
        return table.areAllFilled();
    }

    @Override
    public void startNewRound() {
        table.regenerateTable();
    }

    @Override
    public void provideHelp() {
        table.addBootle(getNewBottle());
    }

    @Override
    public Filling top(int x) {
        return table.top(x);
    }

    @Override
    public boolean singleFilling(int x) {
        return table.singleFilling(x);
    }

    @Override
    public boolean areAllFilled(int x) {
        return table.areAllFilled();
    }

    @Override
    protected Bottle getNewBottle() {
        return new Bottle();
    }

}

