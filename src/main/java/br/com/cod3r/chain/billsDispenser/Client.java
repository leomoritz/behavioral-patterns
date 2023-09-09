package br.com.cod3r.chain.billsDispenser;

public class Client {

	public static void main(String[] args) {
		System.out.println("------------------ ATM with Default Constructor ------------------");
		Dispenser atm = new Dispenser();
		atm.withdraw(500);
		System.out.println("-----------");
		atm.withdraw(230);
		System.out.println("-----------");
		atm.withdraw(178);
		System.out.println("-----------");
		atm.withdraw(66);

		System.out.println("------------------ ATM with Singleton ------------------");
		Dispenser atm2 = Dispenser.getInstance();
		atm2.withdraw(500);
		System.out.println("-----------");
		atm.withdraw(230);
		System.out.println("-----------");
		atm.withdraw(178);
		System.out.println("-----------");
		atm.withdraw(66);
	}
}
