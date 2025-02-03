public class Node {
    private int value;
    private int proceed;

    public Node(int value, int proceed) {
        this.value = value;
        this.proceed = proceed;
    }

    public int getProceed() {
        return proceed;
    }

    public int getValue() {
        return value;
    }
}
