
public class FunctionalExample {
	static interface Function {
		double doWith (double[] data);
	}
	
	static class Datum {
		private double[] data = new double[] { 4, 7, 2, 9};
		
		public double compute(Function f) {
			return f.doWith(data);
		}
	}

	public static void main(String[] args) {
		Datum datum = new Datum();
		double first = datum.compute(data -> data[0]);
		double sum = datum.compute(data -> {
			double acc = 0;
			for (double d : data) {
				acc += d;
			}
			return acc;
		   });
	}

}
