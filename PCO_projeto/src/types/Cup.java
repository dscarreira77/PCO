package types;

public class Cup extends Bottle {
    public static final int CUP_SIZE = 1;
    private static final int TIMES_OF_USAGES = 3;
    private int usages;

    public Cup() {
        super(CUP_SIZE);
        this.usages = 0; 
    }

    public Cup(Filling[] content) {
        super(content.length > 0 ? content[0] : null); 
        this.usages = 0;
    }

    @Override
    public boolean receive(Filling s) {
        if (usages >= TIMES_OF_USAGES) {
            System.out.println("Cup has reached maximum usages and cannot receive more content.");
            return false; 
        } else {
            boolean received = super.receive(s);
            if (received) {
                usages++;
            }
            return received;
        }
    }
}
