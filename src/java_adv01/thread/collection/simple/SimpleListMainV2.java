package java_adv01.thread.collection.simple;

import static java_adv01.util.ThreadUtils.sleep;
import static java_adv01.util.MyLogger.*;

import java_adv01.thread.collection.simple.list.BasicList;
import java_adv01.thread.collection.simple.list.SimpleList;

/*
 * 실행 결과
15:37:44.359 [     main] BasicList 
15:37:44.474 [ Thread-2] Thread-2:list.add(B) 
15:37:44.474 [ Thread-1] Thread-1:list.add(A) 
15:37:44.474 [     main] [B, null] size = 2, capacity = 5 
 * */
public class SimpleListMainV2 {

	public static void main(String args[]) throws InterruptedException {
		test(new BasicList());

	}

	private static void test(SimpleList list) throws InterruptedException {

		log(list.getClass().getSimpleName());

		// A를 리스트에 저장하는 코드
		Runnable addA = new Runnable() {

			@Override
			public void run() {
				list.add("A");
				log("Thread-1:list.add(A)");
			}
		};

		// B를 리스트에 저장하는 코드
		Runnable addB = new Runnable() {

			@Override
			public void run() {
				list.add("B");
				log("Thread-2:list.add(B)");
			}
		};

		Thread thread1 = new Thread(addA, "Thread-1");
		Thread thread2 = new Thread(addB, "Thread-2");
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		log(list);

	}

}
