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
	 * uncertain ???????
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
		Table table = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);
		return table;
	}

    protected abstract Bottle getNewBottle(){
		return addBootle(Bottle);
	};

	public abstract void updateScore(){
		return updatedScore;
	};
	

	public abstract int score(){
		return score;
	};
}

