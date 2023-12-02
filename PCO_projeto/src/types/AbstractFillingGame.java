package types;

public abstract class AbstractFillingGame implements FillingGame {

    public static String EOL = System.lineSeparator();
	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 */
	public AbstractFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
	}

    protected abstract Bottle getNewBottle();

	public abstract void updateScore();

	public abstract int score();
}

