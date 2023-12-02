package types;
import types.Table;

public abstract class AbstractFillingGame implements FillingGame {

    public static String EOL = System.lineSeparator();
	protected Filling[] symbols;
    protected int numberOfUsedSymbols;
    protected int seed;
    protected int bootleSize;
    protected int score;

	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 */
	public AbstractFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
		this.symbols = symbols;
		this.numberOfUsedSymbols = numberOfUsedSymbols;
		this.seed = seed;
		this.bootleSize = bootleSize;
		this.score = 0;
	}

    protected abstract Bottle getNewBottle();

	public abstract void updateScore();

	public abstract int score();
}

