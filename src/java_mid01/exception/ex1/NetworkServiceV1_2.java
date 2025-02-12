package java_mid01.exception.ex1;

public class NetworkServiceV1_2 {
	
	public void sendMessage(String data) {
		String address= "http://example.com";
		NetworkClientV1 client = new NetworkClientV1(address);
		client.initError(data); // 에러 호출
		
		String connectResult = client.connect();
		// 결과가 성공이 아니다 -> 오류다
		if(isError(connectResult)) {
			System.out.println("[네트워크 오류 발생] 오류 코드: "+connectResult);
			return;
		}
		
		
		String sendResult = client.send(data);
		if(isError(sendResult)) {
			System.out.println("[네트워크 오류 발생] 오류 코드: "+sendResult);
			return; 
		}
		
		client.disconnect();
		
	}
	
	//sendResult.equals -> 리팩토링
	private static boolean isError(String resultCode) {
		return !resultCode.equals("success");
	}

}
