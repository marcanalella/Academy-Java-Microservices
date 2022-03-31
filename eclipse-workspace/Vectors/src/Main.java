import java.util.*;

public class Main {
	
	static class Boh<T> {
		
		private final T x;
		
		public Boh (T x) {
			this.x = x;
		}
		
		public T get() {
			return x;
		}
	}
	
	static class Base {
		
	}
	
	static class Derived extends Base {
		
	}
	
	
	

	public static void main(String[] args) {
		
		int[] v = new int[3];
		System.out.println(Arrays.toString(v));
		v[0] = 4;
		v[1] = 7;
		v[2] = 13;
		System.out.println(Arrays.toString(v));
//		v[3] = 20;
		
		String[] s = new String[] { "a", "b", "c", "d" };
		System.out.println(Arrays.toString(s));
		
		List<String> l = new ArrayList<String>();
		l.add("pippo");
		l.add("pluto");
		l.add("paperino");
//		l.add(4); // new Integer(4)
		
		System.out.println(l);
		l.remove("pluto");
		System.out.println(l);
		
		String o = l.get(1);
		String t = o.concat("ciao");
		
		
		// type erasure
		Object xxxx;
		
//		if (xxxx instanceof List<String>) {
//			
//		}
		
		Base b1 = new Base();
		Derived d1 = new Derived();
		
		Base b2 = new Derived();
//		Derived d2 = new Base();
		
		if (b2 instanceof Derived) {
			// true
		}
		
		// arrays are COVARIANT
		Base[] ab1 = new Base[2];
		Derived[] ad1 = new Derived[2];
		Base[] ab2 = new Derived[2];
		
		Object[] ao1 = ab2;
//		ao1[0] = "pippo"; // error at runtime
		
		List<Base> lb1 = new ArrayList<Base>();
		List<Derived> ld1 = new ArrayList<Derived>();
		
		lb1.addAll(ld1);
		
		// generic types are not COVARIANT
//		List<Base> lb2 = new ArrayList<Derived>();
		
		for (int i = 0; i < l.size(); i++) {
			String sss = l.get(i);
			// do something with sss
		}
		
		for (Iterator<String> j = l.iterator(); j.hasNext(); ) {
			String sss = j.next();
			// do something with sss
		}
		
		for (String sss : l) {
			// do something with sss
		}
		
		List<String> l2 = new LinkedList<String>();
		
		Set<String> set1 = new HashSet<String>();
		set1.add("c");
		set1.add("b");
		set1.add("x");
		set1.add("d");
		set1.add("c");
		System.out.println(set1);
		
		Set<String> set2 = new TreeSet<String>();
		set2.add("c");
		set2.add("b");
		set2.add("d");
		set2.add("e");
		set2.add("c");
		System.out.println(set2);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 27);
		map.put("Jane", 22);
		map.put("Tom", 40);
		
		System.out.println(map);
		
		int x = map.get("Jane");
		System.out.println(x);
		
		Set<String> ks = map.keySet();
		Collection<Integer> vl = map.values();
		
		
	}

}
