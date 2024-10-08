package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class BettingFillingGame extends AbstractFillingGame {
	private Table table;
	private int bet;
	private int maxPlays;

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
	public BettingFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize, int score, int bet,
			int maxPlays) {
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
		if (table.nrMoves < maxPlays) {
			maxPlays--;
			table.addBootle(getNewBottle());
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
		if (isRoundFinished()) {
			if (table.nrMoves < maxPlays) {
				this.score += 2 * bet;
			} else if (table.nrMoves == maxPlays) {
				this.score = 0;
			} else {
				this.score -= bet;
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean isRoundFinished() {
		if (table.areAllFilled() || table.nrMoves >= maxPlays) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isRoundFinished()) {
			sb.append("Score: ").append(score);
			sb.append(EOL);
			sb.append(this.table.toString());
			sb.append("Status: This round is finished.");
			sb.append(table.nrMoves).append(" moves were used.").append(EOL);
		} else {
			sb.append("Score: ").append(score);
			sb.append(EOL);
			sb.append(this.table.toString());
			sb.append("Status: ").append(table.nrMoves).append(" moves have been used until now. You still have ")
					.append(maxPlays - table.nrMoves).append(" moves left.").append(EOL);
		}

		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Bottle getNewBottle() {
		return new Cup();
	}

	@Override
	public void play(int x, int y) {
		updateScore();
		for (int i = 0; i < table.getSizeBottles(); i++) {
			Filling topFillingx = table.top(x);
			Filling topFillingy = table.top(y);
			if ((topFillingx == topFillingy && !table.isFull(y)) || table.isEmpty(y)) {
				table.pourFromTo(x, y);
			} else {
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

	public int jogadas() {
		return table.nrMoves;
	}

	public int numberOfPlaysLeft() {
		return maxPlays - table.nrMoves;
	}
}
