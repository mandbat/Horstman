package custom;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {

	public static void main(String[] args) {
		// Map<String, String> sysprop = System.getenv();
		// for (Map.Entry<String, String> a : sysprop.entrySet()) {
		//
		// System.out.print(a.getKey() + " = ");
		// System.out.println(a.getValue());
		//
		// }

		Thread thread1 = new Thread(new Counter());
		thread1.start();

		Thread thread2 = new Thread(new Counter());
		thread2.start();
	}
}

class Counter implements Runnable {

	@Override
	public void run() {

		Lock lock = new ReentrantLock();

		for (int i = 0; i < 5000; i++) {

			int delay = (int) (Math.random() * 10000);
			int a = this.hashCode();
			System.out.println("Поток: " + a + " it: " + i + " delay: " + delay);
			try {
				lock.lock();
				Thread.sleep(delay);
				lock.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}