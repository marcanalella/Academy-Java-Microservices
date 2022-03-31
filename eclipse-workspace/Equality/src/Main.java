public class Main {
	
	static class Point {
		private int x, y;
		
		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
//		@Override
//		public boolean equals(Object obj) {
//			if (obj == null) {
//				return false;
//			}
//			
//			if (!(obj.getClass() == Point.class)) {
//				return false;
//			}
//			
////			if (!(obj instanceof Point)) {
////				return false;
////			}
//			
//			Point other = (Point)obj;
//			return (this.x == other.x) && (this.y == other.y);
//		}
		
		
		
		
		
		
	}
	
	static class ColoredPoint extends Point {
		private String color;
		public ColoredPoint (int x, int y, String color) {
			super(x, y);
			this.color = color;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!super.equals(obj)) {
				return false;
			}
			
			if (!(obj instanceof ColoredPoint)) {
				return false;
			}
			
			return this.color.equals(((ColoredPoint)obj).color);
		}
	}

	public static void main(String[] args) {
		Integer i1 = new Integer(3);
		Integer i2 = new Integer(4);
		Integer i3 = new Integer(3);
		Integer i4 = i2;
		
		System.out.println("i1 == i2? " + (i1 == i2));
		System.out.println("i1 == i3? " + (i1 == i3));
		System.out.println("i2 == i4? " + (i2 == i4));
		
		System.out.println("i1 eq i2? " + (i1.equals(i2)));
		System.out.println("i1 eq i3? " + (i1.equals(i3)));
		System.out.println("i2 eq i4? " + (i2.equals(i4)));
		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(1, 2);
		
		System.out.println("p1 eq p2? " + (p1.equals(p2)));
		System.out.println("p1 eq p3? " + (p1.equals(p3)));
		
		ColoredPoint cp1 = new ColoredPoint(1, 2, "red");
		ColoredPoint cp2 = new ColoredPoint(1, 2, "blue");
		
		System.out.println("cp1 eq cp2? " + (cp1.equals(cp2)));
		System.out.println("p1 eq cp1? " + (p1.equals(cp1)));
		System.out.println("cp1 eq p1? " + (cp1.equals(p1)));
	}

}
