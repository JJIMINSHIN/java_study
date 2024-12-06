package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 결과
19:13:02.633 [     main] Start 
19:13:02.641 [     main] join() - main 스레드가 thread1, thread2 종료까지 대기 
19:13:02.641 [ thread-1] 작업 시작 
19:13:02.641 [ thread-2] 작업 시작 
19:13:04.683 [ thread-1] 작업 완료 result = 1275 
19:13:04.683 [ thread-2] 작업 완료 result = 3775 
19:13:04.685 [     main] task1.result = 1275 
19:13:04.687 [     main] task2.result = 3775 
19:13:04.688 [     main] task1 + task2 = 5050 
19:13:04.690 [     main] End 
 * 
 * */
public class SumTaskMainV1 {
	
	public static void main(String args[]) throws InterruptedException {
		log("Start");
		
		SumTask task1 = new SumTask(1,50);
		SumTask task2 = new SumTask(51,100);
		
		Thread thread1 = new Thread(task1, "thread-1");
		Thread thread2 = new Thread(task2, "thread-2");
		
		thread1.start();
		thread2.start();
		
		//스레드가 종료될때까지 대기
		log("join() - main 스레드가 thread1, thread2 종료까지 대기");
		thread1.join();
		thread2.join();
		
		log("task1.result = "+task1.result);
		log("task2.result = "+task2.result);
		
		int sumAll = task1.result + task2.result;
		log("task1 + task2 = "+sumAll);
		
		log("End");
	}
	
	static class SumTask implements Runnable{
		int startValue;
		int endValue;
		int result = 0;
		
		public SumTask(int startValue, int endValue) {
			this.startValue = startValue;
			this.endValue = endValue;
		}
		
		@Override
		public void run() {
			log("작업 시작");
			sleep(2000);
			int sum=0;
			for(int i=startValue; i<=endValue; i++) {
				sum += i;
			}
			result = sum;
			log("작업 완료 result = "+result);
			
		}
	}

}