package types;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class Table {

    public static String EOL = System.lineSeparator();
    public static final String empty = "⬜";
    public static final int DIFFICULTY = 3;
    public static final int DEFAULT_BOTTLE_SIZE = 5;
    public int nrMoves = 0;

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
        this.numberOfBottles = Math.max(this.numberOfUsedSymbols, 1);
        this.fillingsCounter = new int[this.numberOfUsedSymbols];
        this.nrMoves = 0;

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

        for (int i = 0; i < DIFFICULTY; i++) {
            this.table.add(new Bottle(bottleSize));
        }
    }

    public void regenerateTable() {
        this.table.clear();
        this.fillingsCounter = new int[this.numberOfUsedSymbols];
    
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
    
        for (int i = 0; i < DIFFICULTY; i++) {
            this.table.add(new Bottle(bottleSize));
        }
    }
    

    public boolean singleFilling(int x) {
        if (x < 0 || x >= table.size()) {
            return false;
        }
    
        Bottle bottle = table.get(x);
        Filling[] content = bottle.getContent();
    
        if (content.length == 0) {
            return false;
        }
    
        Filling firstFilling = content[0];
    
        for (int i = 1; i < content.length; i++) {
            if (content[i] != null && !content[i].equals(firstFilling)) {
                return false;
            }
        }
    
        return true;
    }
    

    public boolean isEmpty(int x) {
        if (x < 0 || x >= table.size()) {
            return false;
        }
    
        Bottle bottle = table.get(x);
        return bottle.isEmpty();
    }
    

    public boolean isFull(int x) {
        if (x < 0 || x >= table.size()) {
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
            return;
        }
        
        Bottle sourceBottle = table.get(i);
        Bottle targetBottle = table.get(j);

        if (!sourceBottle.isEmpty() && !targetBottle.isFull()) {
            Filling pouredFilling = sourceBottle.top();
            if(!targetBottle.isEmpty()){
                Filling targetFilling = targetBottle.top();
                if(!pouredFilling.equals(targetFilling)){
                    nrMoves++;
                    return;
                }
            }
            sourceBottle.pourOut(1);
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
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder tableContent = new StringBuilder();
    
        for (int row = bottleSize - 1; row >= 0; row--) {
            for (Bottle bottle : table) {
                Object content;
                if (row < bottle.size()) {
                    content = bottle.getContent()[row];
                } else {
                    content = Filling.EMPTY;
                }
                tableContent.append(content != null ? content.toString() : empty).append("    ");
            }
            tableContent.append(EOL);
        }
    
        return tableContent.toString();
    }
}
