package types;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Table {

    public static String EOL = System.lineSeparator();
    public static final String empty = "⬜";
    public static final int DIFFICULTY = 3;
    public static final int DEFAULT_BOTTLE_SIZE = 5;
    public int nrMoves = 0;

    private ArrayList<Bottle> bottles;
    private Filling[] symbols;
    private int numberOfUsedSymbols;
    private Random random;
    private int bottleSize;
    private ArrayList<Bottle> table;
    private int numberOfBottles;
    private int[] fillingsCounter;

    public Table(Filling[] symbols, int numberOfUsedSymbols, int seed, int bottleSize) {
        this.symbols = symbols;
        this.numberOfUsedSymbols = Math.min(numberOfUsedSymbols, symbols.length);
        this.random = new Random(seed);
        this.bottleSize = bottleSize;
        this.table = new ArrayList<>();
        this.numberOfBottles = Math.max(this.numberOfUsedSymbols, 1); // Pelo menos uma garrafa
        this.fillingsCounter = new int[this.numberOfUsedSymbols];

        // Adiciona garrafas com conteúdo aleatório
        for (int i = 0; i < numberOfBottles; i++) {
            Filling[] toUse = new Filling[this.bottleSize];

            for (int j = 0; j < this.bottleSize; j++) {
                int n = this.random.nextInt(this.numberOfUsedSymbols);
                this.fillingsCounter[n]++;
                while (this.fillingsCounter[n] > this.bottleSize) {
                    int temp = n;
                    n = this.random.nextInt(this.numberOfUsedSymbols);
                    while (n == temp) {
                        temp = n;
                        n = this.random.nextInt(this.numberOfUsedSymbols);
                    }
                    this.fillingsCounter[n]++;
                }
                Filling s = symbols[n];
                toUse[j] = s;
            }

            Bottle b = new Bottle(toUse);
            this.table.add(b);
        }

        // Adiciona garrafas vazias (Dificuldade definida por defeito)
        for (int i = 0; i < DIFFICULTY; i++) {
            this.table.add(new Bottle(bottleSize));
        }
    }

    public void regenerateTable() {
        this.table.clear(); // Limpa o conteúdo atual da tabela
        this.fillingsCounter = new int[this.numberOfUsedSymbols]; // Reinicia o contador de preenchimentos
    
        // Adiciona garrafas com conteúdo aleatório
        for (int i = 0; i < numberOfBottles; i++) {
            Filling[] toUse = new Filling[bottleSize];
    
            for (int j = 0; j < bottleSize; j++) {
                int n = this.random.nextInt(this.numberOfUsedSymbols);
                this.fillingsCounter[n]++;
                while (this.fillingsCounter[n] > this.bottleSize) {
                    int temp = n;
                    n = this.random.nextInt(this.numberOfUsedSymbols);
                    while (n == temp) {
                        temp = n;
                        n = this.random.nextInt(this.numberOfUsedSymbols);
                    }
                    this.fillingsCounter[n]++;
                }
                Filling s = symbols[n];
                toUse[j] = s;
            }
    
            Bottle b = new Bottle(toUse);
            this.table.add(b);
        }
    
        // Adiciona garrafas vazias (Dificuldade definida por defeito)
        for (int i = 0; i < DIFFICULTY; i++) {
            this.table.add(new Bottle(bottleSize));
        }
    }
    

    public boolean singleFilling(int x) {
        if (x < 0 || x >= table.size()) {
            // Índice fora dos limites da tabela
            return false;
        }
    
        Bottle bottle = table.get(x);
        Filling[] content = bottle.getContent();
    
        if (content.length == 0) {
            // Garrafa vazia
            return false;
        }
    
        Filling firstFilling = content[0];
    
        for (int i = 1; i < content.length; i++) {
            if (content[i] != null && !content[i].equals(firstFilling)) {
                // Encontrou um conteúdo diferente
                return false;
            }
        }
    
        // Todos os conteúdos são iguais
        return true;
    }
    

    public boolean isEmpty(int x) {
        if (x < 0 || x >= table.size()) {
            // Invalid index, cannot check the status
            return false;
        }
    
        Bottle bottle = table.get(x);
        return bottle.isEmpty();
    }
    

    public boolean isFull(int x) {
        if (x < 0 || x >= table.size()) {
            // Invalid index, cannot check the status
            return false;
        }
    
        Bottle bottle = table.get(x);
        return bottle.isFull();
    }
    

    public boolean areAllFilled() {
        for (Bottle bottle : table) {
            if (!bottle.isSingleFilling()) {
                return false;
            }
        }
        return true;
    }


	public void pourFromTo(int i, int j) {
        if (i < 0 || i >= table.size() || j < 0 || j >= table.size() || i == j) {
            // Invalid indices or same indices, cannot perform the operation
            return;
        }
    
        Bottle sourceBottle = table.get(i);
        Bottle targetBottle = table.get(j);
    
        // Check if the source bottle is not empty, the target bottle is not full,
        // and the top fillings of both bottles are the same
        if (!sourceBottle.isEmpty() && !targetBottle.isFull()) {
            Filling pouredFilling = sourceBottle.top(); // Get the top filling without removing it
            if(!targetBottle.isEmpty()){
                Filling targetFilling = targetBottle.top();
                if(!pouredFilling.equals(targetFilling)){
                    return;
                    nrMoves++;
                }
            }
            sourceBottle.pourOut(1); // Pour out one filling from the source bottle
            targetBottle.receive(pouredFilling);
        }
    }
    

    public void addBootle(Bottle bottle) {
        if (bottle != null) {
            table.add(bottle);
        }
    }
    

    public int getSizeBottles() {
        for (Bottle bottle : table) {
            if (!bottle.isEmpty()) {
                return bottle.size();
            }else{
                return 0;
            }
        }
        return 0;
    }

    public Filling top(int x) {
        if (x < 0 || x >= table.size()) {
            throw new ArrayIndexOutOfBoundsException("Expected top() to throw, but it didn't");
        }
    
        Bottle bottle = table.get(x);
        if (!bottle.isEmpty()) {
            return bottle.top();
        } else {
            throw new ArrayIndexOutOfBoundsException("Expected top() to throw, but it didn't");
        }
    }

    @Override
    public String toString() {
        StringBuilder tableContent = new StringBuilder();
    
        // Iterating over each position in the bottles
        for (int row = bottleSize - 1; row >= 0; row--) {
            for (Bottle bottle : table) {
                Object content;
                if (row < bottle.size()) {
                    content = bottle.getContent()[row];
                } else {
                    content = Filling.EMPTY;  // If the bottle has no content at this position, use an empty filling
                }
                // Adjust the representation as needed for emojis
                tableContent.append(content != null ? content.toString() : empty).append("    ");
            }
            tableContent.append(EOL);  // Adding EOL between the bottles
        }
    
        return tableContent.toString();
    }
    






}
