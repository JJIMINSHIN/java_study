package java_adv01.thread.cas.increment;

import static java_adv01.util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;

public class IncrementThreadMain {
	
	public static final int THREAD_COUNT=1000;

	
	public static void main(String args[]) throws InterruptedException {
		test(new BasicInteger());
		test(new VolatileInteger());
		test(new SyncInteger());
		test(new MyAtomicInteger());
	}

	private static void test(IncrementInteger incrementInteger) throws InterruptedException {
		
		Runnable runnable = new Runnable(){
			
			@Override
			public void run() {
				sleep(100);
				incrementInteger.increment();
			}
		};
		List<Thread> threads = new ArrayList<>();
		
		for(int i=0; i<THREAD_COUNT; i++) {
			Thread thread = new Thread(runnable);
			threads.add(thread);
			thread.start();
		}
		
		for(Thread thread : threads) {
			thread.join();
		}
		
		int result = incrementInteger.get();
		System.out.println(incrementInteger.getClass().getSimpleName()+"  result : "+result);
		
	}
	
}