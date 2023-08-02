package homework.hw9;

public class CompetitiveEater implements Runnable {
	private String name;
	
	CompetitiveEater(String name) {
		this.name = name;
	}
	
	public void run() {
		for (int i = 1; i < 11; i++) {
			try {
				int sleepTime = (int) (Math.random() * (2501)) + 500;
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%s吃第%d碗飯\n", name, i);
			if (i == 10) {
				System.out.printf("%s吃完了！\n", name, i);
			}
		}
	}
	
	public static void main(String[] args) {
		CompetitiveEater ce1 = new CompetitiveEater("饅頭人");
		CompetitiveEater ce2 = new CompetitiveEater("詹姆士");
		Thread t1 = new Thread(ce1);
		Thread t2 = new Thread(ce2);
		
		System.out.println("-----大胃王快食比賽開始！-----");		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----大胃王快食比賽結束！-----");
	}
}
