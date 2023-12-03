package types;

import java.util.ArrayList;
import java.util.Iterator;

public class FinalScoringFillingGame extends AbstractFillingGame {
    private Table table;

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
        super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = 0;
        this.table = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
    }

	public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize, int score){
		super(symbols, numberOfUsedSymbols, seed, bootleSize);
        this.score = score;
        this.table = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
	}
	/**
	 * 
	 */
	@Override
	public void provideHelp() {
			System.out.println("Can't provide Help. No more plays left.");
    }
	

	/**
	 * 
	 */
	@Override
	public int score() {
		return score;
	}


	/**
	 * 
	 * @return
	 */
	@Override
	public void updateScore() {
		if (isRoundFinished()) {
			int numberOfMoves = table.nrMoves;

			if (numberOfMoves < 10) {
				// Player resolved the puzzle in fewer than 10 moves
				score += 1000;
			} else if (numberOfMoves >= 10 && numberOfMoves <= 15) {
				// Player resolved the puzzle in 10 to 15 moves
				score += 500;
			} else if (numberOfMoves > 15 && numberOfMoves <= 25) {
				// Player resolved the puzzle in 15 to 25 moves
				score += 200;
			} else {
				// Player couldn't resolve the puzzle within the specified moves
				score += 0;
			}
		}
	}


	/**
	 * 
	 */
	@Override
	public boolean isRoundFinished() {
		return table.areAllFilled();
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isRoundFinished()){
            sb.append("Score: ").append(score);
            sb.append(EOL);
            sb.append(this.table.toString());
            sb.append("Status: This round is finihed.");
            sb.append(EOL).append(table.nrMoves).append(" moves were used.").append(EOL);
        }else{
            sb.append("Score: ").append(score);
            sb.append(EOL);
            sb.append(this.table.toString());
            sb.append("Status: The round is not finished.").append(EOL).append(table.nrMoves).append(" moves have been used until now.").append(EOL);
        }
        
        return sb.toString();
    }

	@Override
	public Bottle getNewBottle() {
		return new Cup();
	}


	@Override
	public void play(int x, int y) {
		updateScore();
		for(int i = 0; i < table.getSizeBottles();i++){
			Filling topFillingx = table.top(x);
			Filling topFillingy = table.top(y);
			if((topFillingx == topFillingy && !table.isFull(y)) || table.isEmpty(y)){
				table.pourFromTo(x, y);
			}else{
				i = table.getSizeBottles();
			}
		}
		table.nrMoves++;
	}


	@Override
	public void startNewRound() {
		table.regenerateTable();
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

	public int jogadas(){
		return table.nrMoves;
	}
}
