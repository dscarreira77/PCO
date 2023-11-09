package types;


/**
 * An implementation of the types.Symbol interface
 * @author PCO Team
 */
public enum Squares implements Filling {
	YELLOW("1"),
	BROWN("2"),
	RED("3"),
	BLACK("4"),
	ORANGE("5"),
	GREEN("6"),
	PURPLE("7");

	
	
	private String rep;
	Squares(String s) {
		this.rep = s;
	}

	public String toString() {
		return this.rep;
	}

	public Squares[] fillings() {
		return Squares.values();
	}

}
