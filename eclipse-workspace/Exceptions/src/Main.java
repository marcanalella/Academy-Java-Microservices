public class Main {

	public static void main(String[] args)
			throws Exception {

		for (int i = 0; i < 10; i++) {
			try {
				if (i == 7) {
					throw new RuntimeException("i==7!");
				}
				if (i == 8) {
					throw new Exception("i == 8!");
				}
					
				System.out.println(100 / (i - 4));
			} catch (ArithmeticException e) {
				System.out.println("error....");
			} catch (RuntimeException e) {
				System.out.println("Skipping i == 7...");
			}
		}
	}

}
