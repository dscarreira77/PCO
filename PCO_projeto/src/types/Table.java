package types;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Table {

    public static String EOL = System.lineSeparator();
    public static final String empty = "⬜";
    public static final int DIFFICULTY = 3;
    public static final int DEFAULT_BOTTLE_SIZE = 5;

    private List<Bottle> bottles;

    public Table(Filling[] symbols, int numberOfUsedSymbols, int seed, int bottleSize) {
        int minUsedSymbols = Math.min(numberOfUsedSymbols, symbols.length + DIFFICULTY);
        this.bottles = new ArrayList<>();
        Random random = new Random(seed);

        for (int i = 0; i < symbols.length; i++) {
            Filling[] bottleContent = new Filling[bottleSize];
            for (int j = 0; j < bottleSize; j++) {
                bottleContent[j] = symbols[random.nextInt(minUsedSymbols)];
            }
            Bottle bottle = new Bottle(bottleContent);
            bottles.add(bottle);
        }
    }

    public void regenerateTable() {
        Random random = new Random();
        for (Bottle bottle : bottles) {
            Filling[] newContent = new Filling[bottle.size()];
            for (int j = 0; j < bottle.size(); j++) {
                newContent[j] = bottle.getContent()[random.nextInt(bottle.size())];
            }
            bottle.setContent(newContent);
        }
    }

    public boolean singleFilling(int x) {
        if (x >= 0 && x < bottles.size()) {
            return bottles.get(x).isSingleFilling();
        }
        return false;
    }

    public boolean isEmpty(int x) {
        if (x >= 0 && x < bottles.size()) {
            return bottles.get(x).isEmpty();
        }
        return false;
    }

    public boolean isFull(int x) {
        if (x >= 0 && x < bottles.size()) {
            return bottles.get(x).isFull();
        }
        return false;
    }

    public boolean areAllFilled() {
        for (Bottle bottle : bottles) {
            if (!bottle.isEmpty() && !bottle.isSingleFilling()) {
                return false;
            }
        }
        return true;
    }


	public void pourFromTo(int i, int j) {
        if (i >= 0 && i < bottles.size() && j >= 0 && j < bottles.size() && i != j) {
            Bottle sourceBottle = bottles.get(i);
            Bottle targetBottle = bottles.get(j);
            
            if (!sourceBottle.isEmpty() && !targetBottle.isFull()) {
                Filling topFilling = sourceBottle.top();
                boolean poured = targetBottle.receive(topFilling);
                if (poured) {
                    sourceBottle.pourOut();
                }
            }
        }
    }

    public void addBootle(Bottle bottle) {
        if (bottle != null) {
            bottles.add(bottle);
        }
    }

    public int getSizeBottles() {
        return bottles.size();
    }

    public Filling top(int x) {
        if (x >= 0 && x < bottles.size() && !bottles.get(x).isEmpty()) {
            return bottles.get(x).top();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder tableContent = new StringBuilder();
        for (int i = 0; i < bottles.size(); i++) {
            tableContent.append("Bottle ").append(i).append(": ").append(bottles.get(i).toString()).append(EOL);
        }
        return tableContent.toString();
    }
}
