
public class FormatExample {

	public static void main(String[] args) {
		int x = 5;
		double d = 7.4;
		String s = "pippo";
		System.out.println("x = " + x + ", d = " + d);
		System.out.printf("x = %d, d = %f\n", x, d);
		System.out.printf("x = %4d, d = %3.1f\n", x, d);
		System.out.printf("x = %4d, d = %7.2f\n", x, d);
		System.out.printf("x = %-4d, d = %-7.2f***\n", x, d);
		System.out.printf("%-40s***\n", s);
		
		String fmt = String.format("x = %-4d, d = %-7.2f***\n", x, d);
		System.out.println(fmt);
		
		System.err.println("buh!");
	}
}
