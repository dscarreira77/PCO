package types;

import java.util.ArrayList;
import java.util.Iterator;

public class FinalScoringFillingGame extends AbstractFillingGame {
<<<<<<< Updated upstream
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
=======

	public static String EOL = System.lineSeparator();
	private int initialScore;
	private int numberOfMoves;
	private boolean enigmaSolved;
	private int bottleSize;


public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bottleSize) {
	super(symbols, numberOfUsedSymbols, seed, bottleSize);
	this.table = new Table(symbols, numberOfUsedSymbols, seed, bottleSize);
	this.initialScore = 0;
	this.numberOfMoves = 0;
	bottleSize = table.getSizeBottles();
}

    public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bottleSize, int initialScore) {
        super(symbols, numberOfUsedSymbols, seed, bottleSize);
		this.table = new Table(symbols, numberOfUsedSymbols, seed, bottleSize);
        this.initialScore = initialScore;
        this.userScore = initialScore;
        this.enigmaSolved = areAllFilled(1);
>>>>>>> Stashed changes
    }

    @Override
    public void updateScore() {
<<<<<<< Updated upstream
        if (table.areAllFilled()) {
            int moves = table.nrMoves;
            if (moves < 10) {
                this.score += 1000;
            } else if (moves >= 10 && moves <= 15) {
                this.score += 500;
            } else if (moves > 15 && moves <= 25) {
                this.score += 200;
=======
        this.enigmaSolved = table.areAllFilled();
        if (enigmaSolved) {
            if (numberOfMoves < 10) {
                userScore += 1000;
            } else if (numberOfMoves >= 10 && numberOfMoves <= 15) {
                userScore += 500;
            } else if (numberOfMoves > 15 && numberOfMoves <= 25) {
                userScore += 200;
>>>>>>> Stashed changes
            } else {
                userScore -= 100; // Deduct 100 points for moves greater than 25
            }
        }
    }

	@Override
	public String toString() {
		StringBuilder gameState = new StringBuilder();
	
		gameState.append("Score: ").append(userScore).append(EOL);
	
		for (int row = bottleSize - 1; row >= 0; row--) {
			Iterator<Bottle> iterator = table.iterator();
			while (iterator.hasNext()) {
				Bottle bottle = iterator.next();
				Object content;
				if (row < bottle.size()) {
					content = bottle.getContent()[row];
				} else {
					content = Filling.EMPTY;
				}
				String empty = "";
				gameState.append(content != null ? content.toString() : empty).append("    ");
			}
			gameState.append(EOL);
		}
	
		gameState.append(numberOfMoves).append(" moves have been used until now.").append(EOL);
	
		return gameState.toString();
	}
	


<<<<<<< Updated upstream
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
=======
	@Override
	public int score() {
		return this.userScore;
	}
>>>>>>> Stashed changes

	@Override
	public void provideHelp() {
		System.out.println("");
	}

	@Override
	public void startNewRound() {
		table.regenerateTable();
	}

	@Override
	public void play(int x, int y) {
		table.pourFromTo(x, y);
		numberOfMoves++;
		}

	@Override
	public boolean isRoundFinished() {
		if (table.areAllFilled()){
			return true;
		}else{
			return false;
		}
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
