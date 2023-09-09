package br.com.cod3r.chain.billsDispenser;

public class Dispenser {

    private Bill chain;
    private static Dispenser factory;

    /**
     * Montando a cadeia através de um construtor sem argumento que chama o construtor Dispenser(Bill... bills).
     */
    public Dispenser() {
        this(new Bill(100), new Bill(50), new Bill(20), new Bill(10), new Bill(5), new Bill(1));
    }

    /**
     * Montando a cadeia através de uma fábrica que devolve uma instância Dispenser com a cadeia preparada.
     *
     * @return new {@link Dispenser} com a cadeia de notas pronta.
     */
    public static Dispenser getInstance() {
        if (factory == null) {
            Bill billChain = new Bill(100) //
                    .setNext(new Bill(50)) //
                    .setNext(new Bill(20)) //
                    .setNext(new Bill(10)) //
                    .setNext(new Bill(5)) //
                    .setNext(new Bill(1));

            return new Dispenser(billChain);
        }
        return factory;
    }

    public Dispenser(Bill chain) {
        this.chain = chain;
    }

    public Dispenser(Bill... bills) {
        if (bills.length < 1) {
            return;
        }

        for (int index = 0; index < bills.length - 1; index++) {
            Bill currentBill = bills[index];
            Bill nextBill = bills[index + 1];
            currentBill.setNext(nextBill);
        }

        chain = bills[0]; // A cadeia precisa ter um início, por este motivo assume o primeiro item da lista.
    }

    public void withdraw(Integer amount) {
       chain.execute(amount);
    }
}
