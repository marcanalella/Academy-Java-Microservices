public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello kghkgkgkh!");
		
		int n = 30;
		
		if (n < 20) {
			System.out.println("< 20");
		} else {
			System.out.println(">= 20");
		}
		
		switch (n) {
			case 20:
				System.out.println("20");
				break;
			case 30:
				System.out.println("30");
				break;
			default:
				System.out.println("default");				
		}		
	
	for (int i = 0; i < n; i++) {
		System.out.println("loop " + i);
		}
	
	int j = 0;
	
	while (j < n) {
		System.out.println("loop bis " + j);
		j++;
		}
	
	}
	
}

