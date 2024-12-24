package java_bsc.poly.ex.pay1;

/*
 * NullObjectPattern
 */
public class DefaultPay implements Pay {

	@Override
	public boolean pay(int amount) {
		System.out.println("결제 수단이 없습니다.");
		return false;
	}

}