import com.acme.wsclient.*;

public class Main {

	public static void main(String[] args) {
		HelloWorldService svc = new HelloWorldService();
		HelloWorld h = svc.getHelloWorldPort();
		
		String r = h.hello("pippo");
		
		System.out.println(r);

	}

}
