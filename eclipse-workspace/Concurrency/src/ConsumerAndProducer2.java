import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerAndProducer2 {
	private static BlockingQueue<String> buffer = new ArrayBlockingQueue<>(100);
	private static AtomicInteger count = new AtomicInteger();
	private static CountDownLatch countDown;
	
	static class Producer implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				String product = "Product #" + count.getAndIncrement();
				System.err.printf("Produced %s - %s\n", 
								  Thread.currentThread(),
							 	  product);
				buffer.add(product);
			}
			
			countDown.countDown();
		}
	}
	
	static class Consumer implements Runnable {
		@Override
		public void run() {
			for (;;) { 
				try {
					String product = buffer.take();					
					String done = product + " done";
					System.err.println(done);
				} catch (InterruptedException e) {
					System.err.println("Interrupted");
					break;
				}
				
				synchronized (buffer) {
					buffer.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService e = Executors.newFixedThreadPool(20);
		int producerCount = 7;
		countDown = new CountDownLatch(producerCount);
		for (int i = 0; i < producerCount; i++) {
			e.execute(new Producer());
		}
		for (int i = 0; i < 7; i++) {
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
		System.err.printf("Main thread: %s\n", Thread.currentThread().getPriority());
	}
}
