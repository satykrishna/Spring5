package spring.threading.example;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.threading.executor.SpringExecutors;

public class ThreadingApp {

	
	public static void threadsUsingExecutorService() throws InterruptedException, ExecutionException {

		Runnable task = () -> {
			try {
				Thread.sleep(1000 * 10);
				System.out.println("Done sleeping !!! ");
			}
			catch (Exception ex) {
				/* ... */ }
			System.out.println("Thread Name  " + Thread.currentThread().getName());
			System.out.printf("Hello at %s \n", new Date());
		};

		ExecutorService cachedThreadPoolExecutorService = Executors.newCachedThreadPool();
		if (cachedThreadPoolExecutorService.submit(task).get() == null)
			System.out.printf("The cachedThreadPoolExecutorService " + "has succeeded at %s \n", new Date());

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
		if (fixedThreadPool.submit(task).get() == null)
			System.out.printf("The fixedThreadPool has " + "succeeded at %s \n", new Date());

		ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();
		if (singleThreadExecutorService.submit(task).get() == null)
			System.out.printf("The singleThreadExecutorService " + "has succeeded at %s \n", new Date());

		ExecutorService es = Executors.newCachedThreadPool();
		if (es.submit(task, Boolean.TRUE).get().equals(Boolean.TRUE))
			System.out.println("Job has finished!");

		ScheduledExecutorService scheduledThreadExecutorService = Executors.newScheduledThreadPool(10);
		if (scheduledThreadExecutorService.schedule(task, 30, TimeUnit.SECONDS).get() == null)
			System.out.printf("The scheduledThreadExecutorService " + "has succeeded at %s \n", new Date());
		scheduledThreadExecutorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);

	}
	
	private static ApplicationContext appContext;
	
	public static void springFrameWorkThreadTasks() {
		
		appContext = new AnnotationConfigApplicationContext("spring.threading.executor.config");
		
		System.out.println("HI");
		
		SpringExecutors executors = appContext.getBean(SpringExecutors.class);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		springFrameWorkThreadTasks();

	}

}
