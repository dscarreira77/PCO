package types;

public class main {
    

	public String EOL = Table.EOL;
    public static void main(String[] args) {
		Filling[] symbols = Emojis.values();
		int numberOfUsedSymbols = 7;
		int seed =1;
		int bootleSize = 4;
		

		Table tableTeste = new Table(symbols, numberOfUsedSymbols, seed, bootleSize);

		tableTeste.pourFromTo(3, 7);
		tableTeste.pourFromTo(5, 7);
		
		
		tableTeste.pourFromTo(6, 7);
		
		
		System.out.println(tableTeste.toString());
    }
}
