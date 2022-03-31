public class Main {
	static class Car {
		private Insurance insurance;
		public Insurance getInsurance() { return insurance; }
	}
	
	static class Insurance {
		private String name; // never null
		public String getName() { return name; }
	}

	public static void main(String[] args) {
		Car car = new Car();
		////////////////////
		
		String name = null;
		
		if (car != null) {
			Insurance insurance = car.getInsurance();
			
			if (insurance != null) {
				name = insurance.getName();
			}
		}
//		String name = car.getInsurance().getName();
	}

}
