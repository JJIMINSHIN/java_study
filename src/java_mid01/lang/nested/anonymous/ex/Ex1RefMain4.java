package java_mid01.lang.nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMain4 {

	public static void hello(Process process) {
		System.out.println("프로그램 시작");

		process.run();

		System.out.println("프로그램 종료");
	}

	// 참조값 직접 전달
	public static void main(String args[]) {


		System.out.println("Hello 실행");

		hello(new Process() {

			@Override
			public void run() {
				int randomValue = new Random().nextInt(6) + 1;
				System.out.println("주사위 = " + randomValue);
			}
		});
		hello(new Process() {

			@Override
			public void run() {
				for (int i = 0; i <= 3; i++) {
					System.out.println("i = " + i);
				}
			}
		});
	}

}