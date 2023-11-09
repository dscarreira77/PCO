package types;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class FinalScoringFillingGame extends AbstractFillingGame{

	//TODO


	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 */
	public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize) {
	}

	/**
	 * 
	 * @param symbols
	 * @param numberOfUsedSymbols
	 * @param seed
	 * @param bootleSize
	 * @param score
	 */
	public FinalScoringFillingGame(Filling[] symbols, int numberOfUsedSymbols, int seed, int bootleSize, int score) {
	
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
	public void updateScore() {
	}
	
	/**
	 * 
	 */
	public boolean isRoundFinished(){
		return false;
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
	public Bottle getNewBootle() {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return null;


	}


}
