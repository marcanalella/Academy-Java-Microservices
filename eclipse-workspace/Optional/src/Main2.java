import java.util.Optional;

public class Main2 {
	static class Car {
		private Insurance insurance;
		public Optional<Insurance> getInsurance() {
			return Optional.ofNullable(insurance);
		}
	}

	static class Insurance {
		private String name;
		public String getName() {
			return name;
		}
	}
	private static String getDefaultName() {
		return "";
	}
	public static void main(String[] args) {
		Optional<Car> car = Optional.of(new Car());
		////////////////////
		Optional<String> name = car.flatMap(Car::getInsurance).map(Insurance::getName);
//		String name = car.getInsurance().getName();
		String name2 = car.flatMap(Car::getInsurance)
				  .map(Insurance::getName)
				  .orElse("");
		String name3 = car.flatMap(Car::getInsurance)
				  .map(Insurance::getName)
				  .orElse(getDefaultName());
		String name4 = car.flatMap(Car::getInsurance)
				  .map(Insurance::getName)
				  .orElseGet(Main2::getDefaultName);
	}

}
