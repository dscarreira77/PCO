package types;
import types.Table;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class BettingFillingGame extends AbstractFillingGame{
	private Table table;


	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 * @param score
	 * @param bet
	 * @param maxPlays
	 */
	public BettingFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, 
			int bootleSize, int score, int bet, int maxPlays) {
		super(symbols, numberOfUsedSymbols, seed, bootleSize);
		this.score = score;
		this.bet = bet;
		this.maxPlays = maxPlays;

		this.table = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
	}

	
	/**
	 * 
	 */
	@Override
	public void provideHelp() {
		if ( table.nrMoves < maxPlays) {
            maxPlays--;
            addBootle(getNewBootle()); 
        } else {
            System.out.println("Can't provide Help. No more plays left.");
        }
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
		if (isRoundFinished() && table.nrMoves <= maxPlays) {
            score += 2 * bet;
        } else {
            score = bet;
        }
		return score;
    }

	/**
	 * 
	 */
	@Override
	public boolean isRoundFinished() {
		return areAllFilled() || table.nrMoves >= maxPlays;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Game Status:");
		sb.append("\nCurrent Score: ").append(score);
		sb.append("\nMaximum Plays Allowed: ").append(maxPlays);
		sb.append("\nNumber of Moves: ").append(nrMoves);
		sb.append("\nRounds Finished: ").append(isRoundFinished() ? "Yes" : "No");
		
		return sb.toString();
	}


	/**
	 * 
	 * @return
	 */
	@Override
	public Bottle getNewBootle() {
		return new Cup();
	}


}
