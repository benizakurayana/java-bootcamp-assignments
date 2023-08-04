package homework.hw9;

/**
 * This program solves the deadlock in MomSonDeadLock.java.
 */

public class MomSonDeadLockSolved {
	public static boolean isCompleted = false;  // If a thread is completed, it should be set true.
	
	public static void main(String[] args) {
		Account2 acc = new Account2();
		Mom2 m = new Mom2(acc, "媽媽");
		Son2 s = new Son2(acc, "\t\t\t熊大");
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

class Account2 {
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

class Mom2 implements Runnable {
	Account2 acc;
	String name;

	Mom2(Account2 acc, String name) {
		this.acc = acc;
		this.name = name;
	}

	public void financialSupport() {
		while (acc.getBalance() > 3000) {
			if (MomSonDeadLockSolved.isCompleted == true) {
				return;
			}
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
		for (int i = 1; i < 100; i++) {
			if (MomSonDeadLockSolved.isCompleted == true) {
				break;
				}
			System.out.println(name + "的回合======" + i);
			synchronized (acc) {
				financialSupport();
			}
		}
		MomSonDeadLockSolved.isCompleted = true;
		System.out.println("媽媽執行完成");
	}
}

class Son2 implements Runnable {
	Account2 acc;
	String name;

	Son2(Account2 acc, String name) {
		this.acc = acc;
		this.name = name;
	}

	public void educationalExpense() {
		
		while (acc.getBalance() < 1000) {
			if (MomSonDeadLockSolved.isCompleted == true) {
				return;
			}
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
			acc.notify();
	}

	public void run() {
		for (int i = 1; i < 11; i++) {

			if (MomSonDeadLockSolved.isCompleted == true) {
				break;
			}
			System.out.println(name + "的回合======" + i);
			synchronized (acc) {
				educationalExpense();
			}
		}
		MomSonDeadLockSolved.isCompleted = true;
		System.out.println("熊大執行完成");
	}
}
