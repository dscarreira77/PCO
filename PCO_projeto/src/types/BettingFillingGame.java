package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class BettingFillingGame extends AbstractFillingGame{



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
	
	}

	
	/**
	 * 
	 */
	@Override
	public void provideHelp() {
		if (currentPlays < maxPlays) {
            currentPlays++;
            addBootle(new Cup()); // Assuming addBootle() adds a Cup to the game
        } else {
            // Maximum number of plays reached
        }
    }
	


	

	/**
	 * 
	 */
	@Override
	public int score() {
		return this.score;
	}

	/**
	 * 
	 */
	@Override
	public boolean isRoundFinished() {
		return currentPlays >= maxPlays || super.isRoundFinished();
	}


	/**
	 * 
	 * @return
	 */
	public int numberOfPlaysLeft() {
		return 0;
	}


	/**
	 * 
	 * @return
	 */
	@Override
	public Bottle getNewBootle() {
		return new Cup();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public void updateScore() {
		if (isRoundFinished() && currentPlays <= maxPlays) {
            score += 2 * bet;
        } else {
            score -= bet;
        }
        return score;
    }




}
