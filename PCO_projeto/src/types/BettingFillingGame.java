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

	}


	

	/**
	 * 
	 */
	@Override
	public int score() {
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public boolean isRoundFinished() {
		return false;

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
		return null;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public void updateScore() {

	}




}
