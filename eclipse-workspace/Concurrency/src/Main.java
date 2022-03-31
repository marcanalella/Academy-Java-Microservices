import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	private volatile static int n = 0;
	private final static Object monitor = new Object();
	private static void doSomething100() {
		for (int i = 0; i < 10000; i++) {
			int m;
			synchronized (monitor) {
				m = n++;
			}
			
			System.err.println("Do something " + m);
		}
	}
	
	private final static AtomicInteger an = new AtomicInteger();

	private static void doSomething100bis() {
		for (int i = 0; i < 10000; i++) {
			System.err.println("Do something " + an.getAndIncrement());
		}
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(10);
		e.execute(Main::doSomething100bis);
		e.execute(Main::doSomething100bis);
		e.shutdown();
		
		
		final Callable<String> callable = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				return "pippo";
			}
		};
		
		Future<String> s = e.submit(callable);
		
		boolean x = s.isDone();
		try {
			String ss = s.get();
		} catch (InterruptedException ex) {
		} catch (ExecutionException ex) {
			Throwable ex2 = ex.getCause(); // exception thrown by call
		}
		
		s.cancel(false);
	}
}
