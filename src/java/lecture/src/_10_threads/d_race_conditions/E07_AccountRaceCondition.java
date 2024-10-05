package _10_threads.d_race_conditions;

/** Demonstrate race condition.
 * <p>
 * - Bank account initially contains 5000 Euro<br>
 * - Parallel threads: Make 2000 deposits and withdrawals of the same value.<br>
 * - Afterward, account balance should theoretically be the same, but typically is not!<br>
 * - Reason: Race conditions in parallel call of deposit and withdrawal methods.
 * <br><br>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E07_AccountRaceCondition {

	public static void main(String[] args) throws InterruptedException {
		Account account = new Account();
		DepositThread depositThread = new DepositThread(account);
		WithdrawThread withdrawThread = new WithdrawThread(account);

		account.balance = 5000.0;
		System.out.println("Ursprünglicher Kontostand\t: " + account.balance);
		depositThread.start();
		withdrawThread.start();
		depositThread.join();
		withdrawThread.join();
		System.out.println("Nach gleichen Ein-/Auszahlungen\t: " + account.balance);
	}
}

/** Represents bank account
 */
class Account {
	double balance;
	
	public void deposit(double amount) {
		double newBalance = balance + amount;

		if (newBalance > balance) {
			balance = newBalance;
		}
	}

	public void withdraw(double amount) {
		double newBalance = balance - amount;

		if (newBalance >= 0.0) {
			balance = newBalance;
		}
	}
}

/** Makes 2000 deposits of value 1 to an account.
 */
class DepositThread extends Thread {
	private final Account account;

	public DepositThread(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 2000; i++) {
			account.deposit(1.0);
		}
	}
}

/** Makes 2000 withdrawals of value 1 to an account.
 */
class WithdrawThread extends Thread {
	private final Account account;

	public WithdrawThread(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 2000; i++) {
			account.withdraw(1.0);
		}
	}
}
