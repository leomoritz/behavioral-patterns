package br.com.cod3r.chain.billsDispenser;

public class Bill {

    private Integer value;
    private Bill next;

    public Bill() {
    }

    public Bill(Integer value) {
        this.value = value;
    }

    public Bill(Integer value, Bill next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Bill getNext() {
        return next;
    }

    public Bill setNext(Bill next) {
        this.next = next;
        return this;
    }

    public void execute(Integer remaining) {
        if (remaining >= value) {
            Integer bill = remaining / value;
            remaining %= value;
            System.out.println(String.format("- %d bill(s) of $%d, $%d remaining", bill, value, remaining));
        }
        if (remaining == 0) return;
        if (next != null) next.execute(remaining);
    }
}
