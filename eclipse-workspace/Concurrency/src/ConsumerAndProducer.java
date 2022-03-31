import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ConsumerAndProducer {
//	private static AtomicReference<String> buffer = new AtomicReference<>();
//	private static List<String> buffer = new ArrayList<>();
	private static Queue<String> buffer = new ArrayDeque<>();
	private static AtomicInteger count = new AtomicInteger();
	private static CountDownLatch countDown;
	
	static class Producer implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				String product = "Product #" + count.getAndIncrement();
				System.err.println("Produced " + product);
								
				synchronized (buffer) {
					buffer.add(product);
					buffer.notifyAll();
				}
			}
			
			countDown.countDown();
		}
	}
	
	static class Consumer implements Runnable {
		@Override
		public void run() {
outer:		for (;;) { 
				String product = null;
				synchronized (buffer) {
					while ((product = buffer.poll()) == null) {
						try {
							buffer.wait();
						} catch (InterruptedException e) {
							System.err.println("Interrupted");
							break outer; // otherwise 'return'
						}
					}
					buffer.notifyAll();
				}
				
				String done = product + " done";
				System.err.println(done);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService e = Executors.newFixedThreadPool(20);
		int producerCount = 5;
		countDown = new CountDownLatch(producerCount);
		for (int i = 0; i < producerCount; i++) {
			e.execute(new Producer());
		}
		for (int i = 0; i < 5; i++) {
			e.execute(new Consumer());
		}
		
		countDown.await();
		System.err.println("All producers done");
		
		synchronized (buffer) {
			while (!buffer.isEmpty()) {
				buffer.wait(); 
			}
		}
		System.err.println("Buffer empty");
		e.shutdownNow();
	}
}
