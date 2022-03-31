
public class InnerClassExample {

	public static void main(String[] args) {
		Shooter s = () -> System.out.println("Bang!");
		s.shoot();
	}
}
