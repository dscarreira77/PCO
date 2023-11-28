package types;

public class Cup extends Bottle {
    public static final int CUP_SIZE = 1;
    private static final int TIMES_OF_USAGES = 3;

    private int usages;

    public Cup() {
        super();
        this.usages = 0;
    }

    public Cup(Filling[] content) {
        super(content);
        this.usages = 0;
    }

    public int getCupSize() {
        return CUP_SIZE;
    }

    /**
     * Redefines the receive method. Stops receiving new contents when the number of usages exceeds 3.
     *
     * @param s The filling to receive.
     * @return true if the filling is received, false otherwise.
     */
    @Override
    public boolean receive(Filling s) {
        if (getUsages() > TIMES_OF_USAGES) {
            System.out.println("Cup cannot receive new contents. Maximum usages reached.");
            return false;
        } else {
            boolean received = super.receive(s);
            if (received) {
                incrementUsages();
            }
            return received;
        }
    }

    private int getUsages() {
        return this.usages;
    }

    private void incrementUsages() {
        this.usages++;
    }
}
