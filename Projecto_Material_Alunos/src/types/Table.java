package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class Table {

	public static String EOL = System.lineSeparator();

	public static final String empty = "⬜";

	public static final int DIFICULTY = 3;

	public static final int DEFAULT_BOTTLE_SIZE = 5; 


	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 */
	public Table(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
	}

	/**
	 * 
	 */
	public void regenerateTable() {
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
	 * @param x
	 * @return
	 */
	public boolean isEmpty(int x) {
		return false;
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	public boolean isFull(int x) {
		return false;
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
	 * @param i
	 * @param j
	 */
	public void pourFromTo(int i, int j) {
		
	}

	/**
	 * 
	 * @param bottle
	 */
	public void addBootle(Bottle bottle) {
		
	}

	/**
	 * 
	 * @return
	 */
	public int getSizeBottles() {
		return 0;
	}


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
	 */
	public String toString() {
		return null;
	}

}
