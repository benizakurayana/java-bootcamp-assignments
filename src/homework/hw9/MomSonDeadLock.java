package homework.hw9;

/**
 * This program simulates a scenario where two threads read and write one shared
 * object with synchronization and cause a deadlock. 
 */

public class MomSonDeadLock {
	public static void main(String[] args) {
		Account acc = new Account();
		Mom m = new Mom(acc, "媽媽");
		Son s = new Son(acc, "\t\t\t熊大");
		Thread tm = new Thread(m);
		Thread ts = new Thread(s);
		
		System.out.println("起始餘額：" + acc.getBalance() + "\n==========");
		tm.start();
		ts.start();

		try {
			tm.join();
			ts.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("程式結束");
	}
}

class Account {
	private int balance = 0;

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}
}

class Mom implements Runnable {
	Account acc;
	String name;

	Mom(Account acc, String name) {
		this.acc = acc;
		this.name = name;
	}

	public void financialSupport() {
		while (acc.getBalance() > 3000) {
			System.out.println(name + "看到餘額在3000以上，停止匯款");
			try {
				acc.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		acc.deposit(2000);
		System.out.println(name + "存了2000，帳戶共有：" + acc.getBalance());
		acc.notify();
		System.out.println("熊大被老媽告知帳戶已經有錢！");
	}

	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println(name + "的回合======" + i);
			synchronized (acc) {
				financialSupport();
			}
		}
	}
}

class Son implements Runnable {
	Account acc;
	String name;

	Son(Account acc, String name) {
		this.acc = acc;
		this.name = name;
	}

	public void educationalExpense() {
		while (acc.getBalance() < 1000) {
			System.out.println(name + "看到帳戶沒錢，暫停提款");
			try {
				acc.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		acc.withdraw(1000);
		System.out.println(name + "領了1000，帳戶共有：" + acc.getBalance());
		if (acc.getBalance() < 2000) {
			System.out.println(name + "看到餘額在2000以下，要求匯款");
			acc.notify();
			System.out.println("\t\t\t媽媽被熊大要求匯款！");
		}
	}

	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println(name + "的回合======" + i);
			synchronized (acc) {
				educationalExpense();
			}
		}
	}
}
