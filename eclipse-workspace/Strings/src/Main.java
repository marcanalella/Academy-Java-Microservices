import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	static class Immutable {
		private final StringBuilder s = new StringBuilder();
		public Immutable (String s) {
			this.s.append(s);
		}
		public String getText() {
			return s.toString();
		}
	}
	
	static class WannabeImmutable {
		private final StringBuilder s = new StringBuilder();
		public WannabeImmutable (String s) {
			this.s.append(s);
		}
		public StringBuilder getText() {
			return s;
		}
	}
	
	static class WannabeImmutable2 {
		private final StringBuilder s;
		public WannabeImmutable2 (StringBuilder s) {
			this.s = s;
		}
		public String getText() {
			return s.toString();
		}
	}
	
	
	public static void main(String[] args) {
		
		int x = 4;
		String s1 = "pippo"; // new String("pippo")
		String s2 = "paperino"; // new String("paperino")
		String s3 = s1;
		
		s1 = "ciao " + s1;
		s2 = "ciao ".concat(s2); // same as above
		
		final StringBuilder sb1 = new StringBuilder();
		
		for (int i = 0; i < 100; i++) {
			sb1.append("*");
		}
		
		System.out.println(sb1);
		String s4 = sb1.toString();
		
		// internal status leak (internal status exposure)
		WannabeImmutable w = new WannabeImmutable("pippo");
		w.getText().append(" e soreta");
		System.out.println(w.getText());
		
		StringBuilder p = new StringBuilder("pippo");
		WannabeImmutable2 w2 = new WannabeImmutable2(p);
		p.append(" e soreta");
		
		
		String s5 = "nel mezzo del cammin di nostra vita";
		int i5 = s5.indexOf("cammin"); // 14
		String s6 = s5.substring(0, i5); // "Nel mezzo del "
		String s7 = s5.substring(i5); // "cammin di nostra vita"
		
		String s8 = "32345";
		int i8 = Integer.parseInt(s8);
		String s9 = "3.14";
		double d8 = Double.parseDouble(s9);
		
		String s10 = Double.toString(d8);
		
		Pattern pt = Pattern.compile(".*(.el).*(.el).*");
		Matcher m = pt.matcher(s5);
		
		System.out.println(s5);
		System.out.println("matches " + m.matches());
		System.out.println("groups  " + m.groupCount());
		System.out.println("group #1 " + m.group(1));
		System.out.println("group #2 " + m.group(2));
		
//		if (s5.matches("...")) { ... }
		
	}
}
