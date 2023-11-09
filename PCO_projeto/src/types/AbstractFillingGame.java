package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public abstract class AbstractFillingGame implements FillingGame {

	public static String EOL = System.lineSeparator();


	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 */
	//public AbstractFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
	//}


	/**
	 * 
	 * @return
	 */
	public int jogadas() {
		return 0;
	}


	/**
	 * 
	 * @return
	 */
	public int getBottlesSize() {
		return 0;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void play(int x, int y) {

	}

	/**
	 * 
	 */
	public void provideHelp() {
	}

	/**
	 * 
	 * @return
	 */
	public abstract Bottle getNewBootle();

	/**
	 * 
	 * @return
	 */
	public abstract void updateScore();

	/**
	 * 
	 * @param x
	 * @return
	 */
	public Filling top(int x) {
		return null;
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	public boolean singleFilling(int x) {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public abstract boolean isRoundFinished();


	/**
	 * 
	 * @return
	 */
	public abstract int score();

	/**
	 * 
	 */
	public void startNewRound() {
		
	}

	/**
	 * 
	 * @return
	 */
	public boolean areAllFilled() {
		return false;
	}

	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		
		return null;
	}

}
